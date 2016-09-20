package ru.javawebinar.topjava.repository.mock;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.AuthorizedUser;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.MealsUtil;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


@Repository
public class InMemoryMealRepositoryImpl implements MealRepository {
    private Map<Integer, MealWithUserId> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        MealsUtil.MEALS.forEach(meal -> save(AuthorizedUser.id(), meal));
    }

    @Override
    public Meal save(int userId, Meal meal) {
        if (meal.isNew()) {
            meal.setId(counter.incrementAndGet());
        }
        repository.put(meal.getId(), new MealWithUserId(userId, meal));
        return meal;
    }

    @Override
    public boolean delete(int userId, int id) {
        MealWithUserId mealWithUserId = repository.get(id);
        return mealWithUserId != null && mealWithUserId.userId == userId && repository.remove(id) != null;
    }

    @Override
    public Meal get(int userId, int id) {
        MealWithUserId mealWithUserId = repository.get(id);
        if (mealWithUserId != null && mealWithUserId.userId == userId) {
            return repository.get(id).meal;
        } else {
            return null;
        }
    }

    @Override
    public List<Meal> getAll(int userId) {
        List<Meal> meals = repository.values().stream()
                .filter(mealWithUserId -> mealWithUserId.userId == userId)
                .map(mealWithUserId -> mealWithUserId.meal)
                .collect(Collectors.toList());
        Collections.sort(meals, (m1, m2) -> m1.getDateTime().compareTo(m2.getDateTime()));
        return meals;
    }

    private class MealWithUserId {
        int userId;
        Meal meal;

        MealWithUserId(int userId, Meal meal) {
            this.userId = userId;
            this.meal = meal;
        }
    }

    @Override
    public List<Meal> getFilteredByDate(int userId, LocalDate startDate, LocalDate endDate) {
        List<Meal> meals = repository.values().stream()
                .filter(mealWithUserId -> mealWithUserId.userId == userId)
                .filter(mealWithUserId -> !(mealWithUserId.meal.getDate().isBefore(startDate)))
                .filter(mealWithUserId -> !(mealWithUserId.meal.getDate().isAfter(endDate)))
                .map(mealWithUserId -> mealWithUserId.meal)
                .collect(Collectors.toList());
        Collections.sort(meals, (m1, m2) -> m1.getDateTime().compareTo(m2.getDateTime()));
        return meals;
    }
}


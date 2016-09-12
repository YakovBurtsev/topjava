package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Burtsev on 11.09.2016.
 */
public class DaoMap implements Dao {

    private static Map<Integer, Meal> meals = new ConcurrentHashMap<>();

    private static AtomicInteger id = new AtomicInteger(-1);

    //initializing
    static {
        List<Meal> listOfMeals = Arrays.asList(
                new Meal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
                new Meal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510),
                new Meal(LocalDateTime.of(2015, Month.JUNE, 1, 10, 0), "Завтрак", 1000),
                new Meal(LocalDateTime.of(2015, Month.JUNE, 1, 13, 0), "Обед", 500),
                new Meal(LocalDateTime.of(2015, Month.JUNE, 1, 20, 0), "Ужин", 490)
        );
        listOfMeals.forEach(meal -> {
            meal.setId(id.incrementAndGet());
            meals.put(meal.getId(), meal);
        });
    }

    @Override
    public void add(Meal meal) {
        meal.setId(id.incrementAndGet());
        meals.put(meal.getId(), meal);
    }

    @Override
    public void delete(int id) {
        meals.remove(id);
    }

    @Override
    public void update(Meal meal) {
        meals.put(meal.getId(), meal);
    }

    @Override
    public Meal getById(int id) {
        return meals.get(id);
    }

    @Override
    public List<Meal> getAll() {
        return new ArrayList<>(meals.values());
    }
}

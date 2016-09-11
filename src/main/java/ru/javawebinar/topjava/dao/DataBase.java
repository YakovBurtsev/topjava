package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

/**
 * Created by Burtsev on 11.09.2016.
 */
public class DataBase {

    private static Map<Integer, Meal> meals = new HashMap<>();

    private static int id = -1;

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
        listOfMeals.forEach(DataBase::add);
    }

    public static void add(Meal meal) {
        meal.setId(id++);
        meals.put(meal.getId(), meal);
    }

    public static void delete(int id) {
        meals.remove(id);
    }

    public static void update(Meal meal) {
        meals.put(meal.getId(), meal);
    }

    public static List<Meal> getAll() {
        return new ArrayList<Meal>(meals.values());
    }

}

package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;

import java.util.List;

/**
 * GKislin
 * 06.03.2015.
 */
public interface MealRepository {
    Meal save(int userId, Meal Meal);

    // false if not found
    boolean delete(int userId, int id);

    // null if not found
    Meal get(int userId, int id);

    List<Meal> getAll(int userId);
}

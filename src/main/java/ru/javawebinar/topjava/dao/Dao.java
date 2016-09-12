package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.util.List;

/**
 * Created by Burtsev on 11.09.2016.
 */
public interface Dao {
    void add(Meal meal);
    void delete(int id);
    void update(Meal meal);
    Meal getById(int id);
    List<Meal> getAll();
}

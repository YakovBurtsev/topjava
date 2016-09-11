package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.util.List;

/**
 * Created by Burtsev on 11.09.2016.
 */
public class DaoImpl implements Dao {

    @Override
    public void add(Meal meal) {
        DataBase.add(meal);
    }

    @Override
    public void delete(int id) {
        DataBase.delete(id);
    }

    @Override
    public void update(Meal meal) {
        DataBase.update(meal);
    }

    @Override
    public List<Meal> getAll() {
        return DataBase.getAll();
    }
}

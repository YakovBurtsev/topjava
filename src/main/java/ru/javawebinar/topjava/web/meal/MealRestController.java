package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;

import java.util.List;

/**
 * GKislin
 * 06.03.2015.
 */
@Controller
public class MealRestController {
    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private MealService service;

    public List<Meal> getAll(int userId) {
        LOG.info("getAll");
        return service.getAll(userId);
    }

    public Meal get(int userId, int id) {
        LOG.info("get " + id);
        return service.get(userId, id);
    }

    public Meal create(int userId, Meal meal) {
        meal.setId(null);
        LOG.info("create " + meal);
        return service.save(userId, meal);
    }

    public void delete(int userId, int id) {
        LOG.info("delete " + id);
        service.delete(userId, id);
    }

    public void update(int userId, Meal meal, int id) {
        meal.setId(id);
        LOG.info("update " + meal);
        service.update(userId, meal);
    }

}

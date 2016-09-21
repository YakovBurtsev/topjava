package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.AuthorizedUser;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.to.MealWithExceed;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.util.MealsUtil;

import java.time.LocalDate;
import java.time.LocalTime;
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

    public List<MealWithExceed> getAll() {
        LOG.info("getAll");
        int userId = AuthorizedUser.id();
        return MealsUtil.getWithExceeded(service.getAll(userId), MealsUtil.DEFAULT_CALORIES_PER_DAY);
    }

    public Meal get(int id) {
        LOG.info("get " + id);
        int userId = AuthorizedUser.id();
        return service.get(userId, id);
    }

    public Meal create(Meal meal) {
        meal.setId(null);
        LOG.info("create " + meal);
        int userId = AuthorizedUser.id();
        return service.save(userId, meal);
    }

    public void delete(int id) {
        LOG.info("delete " + id);
        int userId = AuthorizedUser.id();
        service.delete(userId, id);
    }

    public void update(Meal meal, int id) {
        meal.setId(id);
        LOG.info("update " + meal);
        int userId = AuthorizedUser.id();
        service.update(userId, meal);
    }

    public List<MealWithExceed> getFilteredByDateTime(LocalDate startDate, LocalTime startTime,
                                                      LocalDate endDate, LocalTime endTime) {
        int userId = AuthorizedUser.id();

        LOG.info("getFilteredByDateTime");

        return MealsUtil.getFilteredWithExceeded(service.getFilteredByDate(userId, startDate, endDate),
                startTime, endTime, MealsUtil.DEFAULT_CALORIES_PER_DAY);
    }

}

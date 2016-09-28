package ru.javawebinar.topjava.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.DbPopulator;
import ru.javawebinar.topjava.util.TimeUtil;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static ru.javawebinar.topjava.MealTestData.*;
import static ru.javawebinar.topjava.UserTestData.USER_ID;
import static ru.javawebinar.topjava.UserTestData.ADMIN_ID;

/**
 * Created by Burtsev on 28.09.2016.
 */

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class MealServiceImplTest {

    @Autowired
    private MealService service;

    @Autowired
    private DbPopulator dbPopulator;

    @Before
    public void setUp() throws Exception {
        dbPopulator.execute();
    }

    @Test
    public void testGet() throws Exception {
        Meal meal = service.get(USER_BREAKFAST_ID, USER_ID);
        MATCHER.assertEquals(USER_BREAKFAST, meal);
    }

    @Test(expected = NotFoundException.class)
    public void testGetNotFound() throws Exception {
        service.get(1, USER_ID);
    }

    @Test(expected = NotFoundException.class)
    public void testGetOtherUserMeal() throws Exception {
        service.get(ADMIN_BREAKFAST_ID, USER_ID);
    }

    @Test
    public void testDelete() throws Exception {
        service.delete(USER_BREAKFAST_ID, USER_ID);
        MATCHER.assertCollectionEquals(Arrays.asList(USER_DINNER, USER_LUNCH), service.getAll(USER_ID));
    }

    @Test(expected = NotFoundException.class)
    public void testDeleteNotFound() throws Exception {
        service.delete(1, USER_ID);
    }

    @Test(expected = NotFoundException.class)
    public void testDeleteOtherUserMeal() throws Exception {
        service.delete(ADMIN_BREAKFAST_ID, USER_ID);
    }

    @Test
    public void testGetBetweenDateTimes() throws Exception {
        Collection<Meal> betweenDateTimes = service.getBetweenDateTimes(
                LocalDateTime.parse("2016-09-27 17:00", TimeUtil.DATE_TIME_FORMATTER),
                LocalDateTime.parse("2016-09-28 15:00", TimeUtil.DATE_TIME_FORMATTER),
                ADMIN_ID);
        MATCHER.assertCollectionEquals(Arrays.asList(ADMIN_LUNCH, ADMIN_BREAKFAST), betweenDateTimes);
    }

    @Test
    public void testGetAll() throws Exception {
        Collection<Meal> all = service.getAll(USER_ID);
        MATCHER.assertCollectionEquals(Arrays.asList(USER_DINNER, USER_LUNCH, USER_BREAKFAST), all);
    }

    @Test
    public void testUpdate() throws Exception {
        Meal updated = new Meal(USER_BREAKFAST);
        updated.setDescription("super breakfast");
        updated.setCalories(1000);
        service.update(updated, USER_ID);
        MATCHER.assertEquals(updated, service.get(updated.getId(), USER_ID));
    }

    @Test(expected = NotFoundException.class)
    public void testUpdateNotFound() throws Exception {
        Meal notExist = new Meal(1, LocalDateTime.now(), "not exist", 100);
        service.update(notExist, USER_ID);
    }

    @Test(expected = NotFoundException.class)
    public void testUpdateOtherUserMeal() throws Exception {
        Meal updated = new Meal(USER_BREAKFAST);
        updated.setDescription("super breakfast");
        updated.setCalories(1000);
        service.update(updated, ADMIN_ID);
    }
    @Test
    public void testSave() throws Exception {
        Meal newMeal = new Meal(LocalDateTime.parse("2016-09-29 15:00", TimeUtil.DATE_TIME_FORMATTER), "new meal", 1500);
        Meal created = service.save(newMeal, USER_ID);
        newMeal.setId(created.getId());
        MATCHER.assertCollectionEquals(Arrays.asList(newMeal, USER_DINNER, USER_LUNCH, USER_BREAKFAST),
                service.getAll(USER_ID));
    }

}
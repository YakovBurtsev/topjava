package ru.javawebinar.topjava;

import ru.javawebinar.topjava.matcher.ModelMatcher;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.TimeUtil;

import java.time.LocalDateTime;

import static ru.javawebinar.topjava.model.BaseEntity.START_SEQ;

/**
 * GKislin
 * 13.03.2015.
 */
public class MealTestData {

    public static final int USER_BREAKFAST_ID = START_SEQ + 2;
    public static final int USER_LUNCH_ID = START_SEQ + 3;
    public static final int USER_DINNER_ID = START_SEQ + 4;
    public static final int ADMIN_BREAKFAST_ID = START_SEQ + 5;
    public static final int ADMIN_LUNCH_ID = START_SEQ + 6;
    public static final int ADMIN_DINNER_ID = START_SEQ + 7;

    public static final Meal USER_BREAKFAST = new Meal(USER_BREAKFAST_ID,
            LocalDateTime.parse("2016-09-27 10:00", TimeUtil.DATE_TIME_FORMATTER), "user breakfast", 500);
    public static final Meal USER_LUNCH = new Meal(USER_LUNCH_ID,
            LocalDateTime.parse("2016-09-27 13:00", TimeUtil.DATE_TIME_FORMATTER), "user lunch", 1000);
    public static final Meal USER_DINNER = new Meal(USER_DINNER_ID,
            LocalDateTime.parse("2016-09-27 18:00", TimeUtil.DATE_TIME_FORMATTER), "user dinner", 600);
    public static final Meal ADMIN_BREAKFAST = new Meal(ADMIN_BREAKFAST_ID,
            LocalDateTime.parse("2016-09-28 10:00", TimeUtil.DATE_TIME_FORMATTER), "admin breakfast", 500);
    public static final Meal ADMIN_LUNCH = new Meal(ADMIN_LUNCH_ID,
            LocalDateTime.parse("2016-09-28 13:00", TimeUtil.DATE_TIME_FORMATTER), "admin lunch", 1200);
    public static final Meal ADMIN_DINNER = new Meal(ADMIN_DINNER_ID,
            LocalDateTime.parse("2016-09-28 18:00", TimeUtil.DATE_TIME_FORMATTER), "admin dinner", 500);

    public static final ModelMatcher<Meal> MATCHER = new ModelMatcher<>();

}

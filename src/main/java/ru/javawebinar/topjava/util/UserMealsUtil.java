package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * GKislin
 * 31.05.2015.
 */
public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 29, 10, 0), "Завтрак", 400),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 29, 13, 0), "Обед", 900),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 29, 20, 0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510),
                new UserMeal(LocalDateTime.of(2015, Month.JUNE, 1, 10, 0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.JUNE, 1, 13, 0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.JUNE, 1, 20, 0), "Ужин", 500)
        );
        List<UserMealWithExceed> filteredWithExceeded =
                getFilteredWithExceeded(mealList, LocalTime.of(11, 0), LocalTime.of(15, 0), 2000);
        for (UserMealWithExceed userMealWithExceed : filteredWithExceeded) {
            System.out.println(userMealWithExceed.getDateTime()
                    .format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")) + " " + userMealWithExceed.isExceed());
        }
    }

    public static List<UserMealWithExceed> getFilteredWithExceeded(
            List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {

        //calculate total calories for each day
        Map<LocalDate, Integer> totalCaloriesOnDate =
                mealList
                        .stream()
                        .collect(Collectors.groupingBy(UserMeal::getLocalDate, Collectors.summingInt(UserMeal::getCalories)));

        //define meals with exceed and filter by time
        return mealList
                .stream()
                .filter(meal -> TimeUtil.isBetween(meal.getLocalTime(), startTime, endTime))
                .map(meal -> new UserMealWithExceed(meal, totalCaloriesOnDate.get(meal.getLocalDate()) > caloriesPerDay))
                .collect(Collectors.toList());

    }
}

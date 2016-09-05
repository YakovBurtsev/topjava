package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
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

        getFilteredWithExceeded(mealList, LocalTime.of(11, 0), LocalTime.of(15, 0), 2000)
                .forEach(System.out::println);
    }

    public static List<UserMealWithExceed> getFilteredWithExceededJava7(
            List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {

        //calculate sum calories for each day
        Map<LocalDate, Integer> sumCaloriesInDay = new HashMap<>();
        for (UserMeal userMeal : mealList) {
            LocalDate date = userMeal.getLocalDate();
            if (sumCaloriesInDay.containsKey(date)) {
                sumCaloriesInDay.put(date, sumCaloriesInDay.get(date) + userMeal.getCalories());
            } else {
                sumCaloriesInDay.put(date, userMeal.getCalories());
            }
        }

        //define meals with exceed and filter by time
        List<UserMealWithExceed> mealsWithExceed = new ArrayList<>();
        for (UserMeal userMeal : mealList) {
            if (TimeUtil.isBetween(userMeal.getLocalTime(), startTime, endTime)) {
                mealsWithExceed.add(new UserMealWithExceed(
                        userMeal.getDateTime(), userMeal.getDescription(), userMeal.getCalories(),
                        sumCaloriesInDay.get(userMeal.getLocalDate()) > caloriesPerDay));
            }
        }

        return mealsWithExceed;
    }

    public static List<UserMealWithExceed> getFilteredWithExceeded(
            List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {

        //calculate total calories for each day
        Map<LocalDate, Integer> totalCaloriesOnDate =
                mealList
                        .stream()
                        .collect(Collectors.groupingBy(UserMeal::getLocalDate,
                                Collectors.summingInt(UserMeal::getCalories)));

        //define meals with exceed and filter by time
        return mealList
                .stream()
                .filter(meal -> TimeUtil.isBetween(meal.getLocalTime(), startTime, endTime))
                .map(meal -> new UserMealWithExceed(meal.getDateTime(), meal.getDescription(), meal.getCalories(),
                        totalCaloriesOnDate.get(meal.getLocalDate()) > caloriesPerDay))
                .collect(Collectors.toList());
    }


}

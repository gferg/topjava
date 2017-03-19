package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

/**
 * Created by user on 3/19/2017.
 */
public class UserMealsUtil {
    public static void main (String ... args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2017, Month.MARCH, 19, 7, 00), "Breakfast", 810),
                new UserMeal(LocalDateTime.of(2017, Month.MARCH, 19, 11, 30), "Lunch", 730),
                new UserMeal(LocalDateTime.of(2017, Month.MARCH, 19, 16, 30), "Tea", 315),
                new UserMeal(LocalDateTime.of(2017, Month.MARCH, 19, 19, 00), "Dinner", 1300)

        );

        getFilteredMealsWithExceeded(mealList, LocalTime.of(7, 00), LocalTime.of(13, 00), 3000);
        //.toLocalDate();
        //.toLocalTime();
    }

    public static List<UserMealWithExceed> getFilteredMealsWithExceeded(List<UserMeal> mealList, LocalTime time1, LocalTime time2, int cal) {
        return null;
    }
}

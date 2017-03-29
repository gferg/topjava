package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by user on 3/19/2017.
 */
public class MealsUtil {
    public static void main (String ... args) {
        List<Meal> mealList = Arrays.asList(
                new Meal(LocalDateTime.of(2017, Month.MARCH, 19, 7, 00), "Breakfast", 810),
                new Meal(LocalDateTime.of(2017, Month.MARCH, 19, 11, 30), "Lunch", 730),
                new Meal(LocalDateTime.of(2017, Month.MARCH, 19, 16, 30), "Tea", 315),
                new Meal(LocalDateTime.of(2017, Month.MARCH, 19, 19, 00), "Dinner", 1300),
                new Meal(LocalDateTime.of(2017, Month.MARCH, 20, 7, 00), "Breakfast", 610),
                new Meal(LocalDateTime.of(2017, Month.MARCH, 20, 11, 30), "Lunch", 780),
                new Meal(LocalDateTime.of(2017, Month.MARCH, 20, 16, 30), "Tea", 415),
                new Meal(LocalDateTime.of(2017, Month.MARCH, 20, 19, 00), "Dinner", 1000)

        );

        List<MealWithExceed> mealsWithExceeded = getFilteredWithExceeded(mealList, LocalTime.of(7, 00), LocalTime.of(13, 00), 3000);
        mealsWithExceeded.forEach(System.out::println);
        //.toLocalDate();
        //.toLocalTime();
    }

    public static List<MealWithExceed> getFilteredWithExceeded(List<Meal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {

        Map<LocalDate, Integer> caloriesSumByDate = meals.stream()
                .collect(
                        Collectors.groupingBy(Meal::getDate, Collectors.summingInt(Meal::getCalories))
                );

        return meals.stream()
                .filter(meal -> TimeUtil.isBetween(meal.getTime(), startTime, endTime))
                .map(meal ->
                        new MealWithExceed(meal.getDateTime(), meal.getDescription(), meal.getCalories(),
                                caloriesSumByDate.get(meal.getDate()) > caloriesPerDay))
                .collect(Collectors.toList());

    }

    public static List<MealWithExceed> getFilteredWithExceededByCycle(List<Meal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {

        final Map<LocalDate, Integer> caloriesSumByDate = new HashMap<>();
        meals.forEach(meal -> caloriesSumByDate.merge(meal.getDate(), meal.getCalories(), Integer::sum));

        final List<MealWithExceed> mealsWithExceeded = new ArrayList<>();
        meals.forEach(meal -> {
            if (TimeUtil.isBetween(meal.getTime(), startTime, endTime)) {
                mealsWithExceeded.add(createWithExceed(meal, caloriesSumByDate.get(meal.getDate()) > caloriesPerDay));
            }
        });
        return mealsWithExceeded;
    }

    public static MealWithExceed createWithExceed(Meal meal, boolean exceeded) {
        return new MealWithExceed(meal.getDateTime(), meal.getDescription(), meal.getCalories(), exceeded);
    }
}

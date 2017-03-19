package ru.javawebinar.topjava.model;

import java.time.LocalDateTime;

/**
 * Created by user on 3/19/2017.
 */
public class UserMealWithExceed {

    protected final LocalDateTime dateTime;

    protected final String description;

    protected final int calories;

    protected final boolean exceed;

    public UserMealWithExceed(LocalDateTime dateTime, String description, int calories, boolean exceed) {
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
        this.exceed = exceed;
    }
}

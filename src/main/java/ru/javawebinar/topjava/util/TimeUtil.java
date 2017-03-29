package ru.javawebinar.topjava.util;

import java.time.LocalTime;

/**
 * Created by user on 3/19/2017.
 */
public class TimeUtil {
    public static boolean isBetween(LocalTime lt, LocalTime startTime, LocalTime endTime) {
        return lt.compareTo(startTime) >= 0 && lt.compareTo(endTime) <= 0;
    }
}

package com.nikgrozev.date.model;

/**
 * Immutable class representing a date.
 */
public class Date {
    private final int day;
    private final int month;
    private final int year;

    public Date(final int day, final int month, final int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    static boolean isLeap(final int year){
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }
}

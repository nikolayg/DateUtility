package com.nikgrozev.date.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Set;
import java.util.stream.IntStream;

/**
 * Immutable class representing a date.
 */
public class Date {
    private static final Set<Integer> LONG_MONTHS = Set.of(1, 3, 5, 7, 8, 10, 12);

    private final int day;
    private final int month;
    private final int year;

    public Date(final int day, final int month, final int year) throws InvalidDateException {
        validate(day, month, year);
        this.day = day;
        this.month = month;
        this.year = year;
    }

    static boolean isLeap(final int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    static int maxDaysInMonth(final int month, final int year) {
        assertThat(month).isBetween(1, 12);
        assertThat(year).isPositive();

        if (LONG_MONTHS.contains(month)) {
            return 31;
        } else if (month == 2) {
            return isLeap(year) ? 29 : 28;
        } else {
            return 30;
        }
    }

    private static void validate(final int day, final int month, final int year) throws InvalidDateException {
        // TODO Add more specific error messages
        if (year <= 0 || month <= 0 || month > 12 || day <= 0 || day > maxDaysInMonth(month, year)) {
            throw new InvalidDateException(String.format("Invalid date %d-%d-%d", day, month, year));
        }
    }

    public long daysSinceAD() {
        long fullLeapYears = IntStream.rangeClosed(0, year).filter(Date::isLeap).count();
        long fullNonLeapYears = year - fullLeapYears;
        long daysInCurrentYear = IntStream.range(1, month).map(m -> maxDaysInMonth(m, year)).sum() + day;

        return fullLeapYears * 366 + fullNonLeapYears * 365 + daysInCurrentYear;
    }
}

package com.nikgrozev.date.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class DateTest {

    @Test
    public void testDaysSinceAD() throws InvalidDateException {
        assertEquals(367, new Date(1, 1, 1).daysSinceAD());
        assertEquals(368, new Date(2, 1, 1).daysSinceAD());

        assertEquals(426, new Date(1, 3, 1).daysSinceAD());
        assertEquals(4809, new Date(1, 3, 13).daysSinceAD());
        assertEquals(370051, new Date(1, 3, 1013).daysSinceAD());
    }

    @Test(expected = InvalidDateException.class)
    public void testCreateDateWithInvalidLeapDate() throws InvalidDateException {
        new Date(29, 2, 1999);
    }

    @Test(expected = InvalidDateException.class)
    public void testCreateDateWithInvalidDay() throws InvalidDateException {
        new Date(31, 4, 1999);
    }

    @Test
    public void testIsLeap() {
        assertTrue(Date.isLeap(4));
        assertTrue(Date.isLeap(12));
        assertTrue(Date.isLeap(96));
        assertTrue(Date.isLeap(196));
        assertTrue(Date.isLeap(400));
        assertTrue(Date.isLeap(404));
        assertTrue(Date.isLeap(1600));
        assertTrue(Date.isLeap(1904));
        assertTrue(Date.isLeap(2000));
        assertTrue(Date.isLeap(404));
        assertTrue(Date.isLeap(2400));

        assertFalse(Date.isLeap(2));
        assertFalse(Date.isLeap(3));
        assertFalse(Date.isLeap(100));
        assertFalse(Date.isLeap(200));
        assertFalse(Date.isLeap(1001));
        assertFalse(Date.isLeap(1900));
        assertFalse(Date.isLeap(2100));
    }

    @Test
    public void tesMaxDaysInMonth() {
        assertEquals(31, Date.maxDaysInMonth(1, 2000));
        assertEquals(31, Date.maxDaysInMonth(3, 2001));
        assertEquals(31, Date.maxDaysInMonth(5, 2002));
        assertEquals(31, Date.maxDaysInMonth(7, 2003));
        assertEquals(31, Date.maxDaysInMonth(8, 2004));
        assertEquals(31, Date.maxDaysInMonth(10, 2005));
        assertEquals(31, Date.maxDaysInMonth(12, 2006));

        assertEquals(30, Date.maxDaysInMonth(4, 2000));
        assertEquals(30, Date.maxDaysInMonth(6, 2001));
        assertEquals(30, Date.maxDaysInMonth(9, 2002));
        assertEquals(30, Date.maxDaysInMonth(11, 2003));

        assertEquals(28, Date.maxDaysInMonth(2, 2001));
        assertEquals(28, Date.maxDaysInMonth(2, 1900));
        assertEquals(29, Date.maxDaysInMonth(2, 1996));
        assertEquals(29, Date.maxDaysInMonth(2, 2000));
    }
}
package com.nikgrozev.date.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class DateTest {

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
}
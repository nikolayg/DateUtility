package com.nikgrozev.date;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * Created by nikolay on 17/12/17.
 */
public class InterpreterTest {

    private static Interpreter interpreter = new Interpreter();

    @Test
    public void intepretsGoodInput() {
        assertEquals("08 01 1995, 24 12 2005, 4003", interpreter.interpret("08 01 1995, 24 12 2005"));
        assertEquals("12 09 1945, 15 04 1969, 8616", interpreter.interpret("15 04 1969, 12 09 1945"));
    }

    @Test
    public void intepretsInvalidInputFormat() {
        assertTrue(interpreter.interpret("08 01 199, 24 12 2005").contains("Error"));
        assertTrue(interpreter.interpret("08 01 1990 24 12 2005").contains("Error"));
        assertTrue(interpreter.interpret("08 01 199, 29 0 2005").contains("Error"));
        assertTrue(interpreter.interpret("08 01 199, 24 12 2005, more things").contains("Error"));
    }

    @Test
    public void intepretsInvalidDates() {
        assertTrue(interpreter.interpret("29 02 1900, 24 12 2005").contains("Error"));
        assertTrue(interpreter.interpret("08 01 1990, 31 11 2005").contains("Error"));
    }
}
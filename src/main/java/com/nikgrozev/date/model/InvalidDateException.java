package com.nikgrozev.date.model;

/**
 * A unchecked exception for invalid dates
 */
public class InvalidDateException extends Exception {

    public InvalidDateException(final String message) {
        super(message);
    }
}
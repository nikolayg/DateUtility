package com.nikgrozev.date;

import com.nikgrozev.date.model.Date;
import com.nikgrozev.date.model.InvalidDateException;

import static java.lang.Integer.parseInt;

/**
 * Interprets a line of user input.
 */
public class Interpreter {
    private static final String INPUT_DATE_PATTERN = "\\d{1,2}\\s+\\d{1,2}\\s+\\d{4}";
    private static final String INPUT_DELIM_PATTERN = "\\s*,\\s*";
    private static final String INPUT_PATTERN = INPUT_DATE_PATTERN + INPUT_DELIM_PATTERN + INPUT_DATE_PATTERN;

    public String interpret(final String input) {
        if (!input.matches(INPUT_PATTERN)) {
            return "Error! The input is not in the form \"DD MM YYYY, DD MM YYYY\"";
        }

        String[] inputs = input.replace(",", " ").split("\\s+");

        try {
            Date date1 = new Date(parseInt(inputs[0]), parseInt(inputs[1]), parseInt(inputs[2]));
            long date1Days = date1.daysSinceAD();

            Date date2 = new Date(parseInt(inputs[3]), parseInt(inputs[4]), parseInt(inputs[5]));
            long date2Days = date2.daysSinceAD();

            return formattedOutput(date1, date2, date1Days - date2Days);
        } catch (InvalidDateException e) {
            return "Error! " + e.getMessage();
        }
    }

    private String formattedOutput(Date date1, Date date2, long delta) {
        if (delta >= 0) {
            return String.format("%s, %s, %d", formatDate(date2), formatDate(date1), delta);
        } else {
            return String.format("%s, %s, %d", formatDate(date1), formatDate(date2), -delta);
        }
    }

    private String formatDate(Date date) {
        return String.format("%02d %02d %04d", date.getDay(), date.getMonth(), date.getYear());
    }
}

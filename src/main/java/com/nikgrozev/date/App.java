package com.nikgrozev.date;

import java.util.Scanner;

/**
 * Created by nikolay on 17/12/17.
 */
public class App {

    public static void main(String[] args) {
        Interpreter interpreter = new Interpreter();

        // Read from the std line by line and interpret
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Input dates ... ");

            while (input.hasNext()) {
                System.out.println(interpreter.interpret(input.nextLine().trim()));
                System.out.println("\nInput new dates ... ");
            }

        } finally {
            System.out.println("End");
        }
    }
}

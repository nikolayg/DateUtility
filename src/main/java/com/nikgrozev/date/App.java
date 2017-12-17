package com.nikgrozev.date;

import java.util.Scanner;

/**
 * Created by nikolay on 17/12/17.
 */
public class App {

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Keep inputing ... and then press Ctrl+C");
            while (input.hasNext()) {
                System.out.println(input.nextLine());
            }

        } finally {
            System.out.println("End");
        }
    }
}

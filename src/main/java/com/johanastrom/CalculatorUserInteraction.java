package com.johanastrom;

import com.johanastrom.calculator.Calculator;

import java.util.Scanner;

/**
 * Johan Åström 28/3 2021
 */

public class CalculatorUserInteraction {

    private static final Scanner sc = new Scanner(System.in);
    private static final Calculator calc = new Calculator();

    public static void menu() {
        System.out.println("============** Johan Åström - Programming Test **============\n");
        boolean loop = true;
        while (loop) {
            System.out.println("Enter a mathematical expression to evaluate; press \"x\" to exit.");
            String userInput = sc.nextLine();
            if (userInput.equalsIgnoreCase("x")) {
                System.out.println("\n============** Good Bye! **============\n");
                loop = false;
                break;
            }
            double result = calc.evaluate(userInput);
            System.out.println("Result: " + result + "\n");
        }

    }
}

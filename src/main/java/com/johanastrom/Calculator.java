package com.johanastrom;

import java.util.Arrays;

/**
 * Johan Åström 26/3 2021
 */

public class Calculator {

    public double evaluate(String expression) {

        if (!expression.substring(0, 1).matches("\\d")){
            System.out.println("Invalid input - 0.0 returned");
            return 0;
        }

        String[] numberStrings = expression.split("\\D+");
        String[] operators = expression.split("\\d+");
        double[] numbers = new double[numberStrings.length];
        for (int i = 0; i < numberStrings.length; i++) {
            numbers[i] = Double.parseDouble(numberStrings[i]);
        }

        /*System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(operators));
        for (double number : numbers) {
            System.out.println(number);
        }
        for (String operator : operators) {
            System.out.println(operator);
        }*/

        double result = numbers[0];
        for (int i = 1; i < operators.length+1 - 1; i++) {
            result = calculate(operators[i], result, numbers[i]);
        }

        return result;
    }

    private double calculate(String operator, double a, double b) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;

        }
        return 0;
    }
}

package com.johanastrom;

/**
 * Johan Åström 26/3 2021
 */

public class Calculator {

    public double evaluate(String expression) {

        expression = expression.replaceAll("\\s", "");

        if (!isValidExpression(expression)){
            System.out.println("Invalid input - 0.0 returned");
            return 0.0;
        }

        String[] numberStrings = expression.split("[^0-9.]+");
        String[] operators = expression.split("\\d+(\\.\\d+)?");
        double[] numbers = new double[numberStrings.length];
        for (int i = 0; i < numberStrings.length; i++) {
            numbers[i] = Double.parseDouble(numberStrings[i]);
        }

        for (int i = 0; i < operators.length; i++) {
            if (operators[i].matches("[*/]")){
                double term = calculateTerms(operators[i], numbers[i-1], numbers[i]);
                numbers[i-1] = term;
                String[] operatorsTemp = new String[operators.length-1];
                double[] numbersTemp = new double[numbers.length-1];
                for (int j = i; j < operators.length-1; j++) {
                    operators[j] = operators[j+1];
                    numbers[j] = numbers[j+1];
                }
                for (int j = 0; j < operatorsTemp.length; j++) {
                    operatorsTemp[j] = operators[j];
                    numbersTemp[j] = numbers[j];
                }
                operators = operatorsTemp;
                numbers = numbersTemp;
                i--;
            }
        }
        double result = numbers[0];
        for (int i = 1; i < operators.length+1 - 1; i++) {
            result = calculateTerms(operators[i], result, numbers[i]);
        }

        return result;
    }

    private double calculateTerms(String operator, double a, double b) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                return 0.0;
        }
    }

    private boolean isValidExpression(String expression){
        return !expression.substring(0, 1).matches("\\D") &&
                !expression.matches(".*[a-zA-Z].*") &&
                !expression.matches(".*\\D{2,10}.*");
    }
}

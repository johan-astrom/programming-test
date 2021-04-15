package com.johanastrom.calculator;

/**
 * Johan Åström 26/3 2021
 */

public class Calculator {

    //Level 1
    public double evaluateOneTerm(String expression){
        expression = expression.replaceAll("\\s", "");

        if (isInvalidExpression(expression)){
            System.out.println("Invalid input - 0.0 returned");
            return 0.0;
        }
        String[] operators = expression.split("\\d+(\\.\\d+)?");
        double[] numbers = extractNumbers(expression);

        if (numbers.length>2 || operators.length>2){
            System.out.println("Expression is too long - please enter exactly two numbers and one operand! 0.0 returned.");
            return 0.0;
        }

        return calculateTerms(operators[1], numbers[0], numbers[1]);
    }

    //Level 2
    public double evaluateWithSamePrecedence(String expression) {
        expression = expression.replaceAll("\\s", "");

        if (isInvalidExpression(expression)){
            System.out.println("Invalid input - 0.0 returned");
            return 0.0;
        }
        String[] operators = expression.split("\\d+(\\.\\d+)?");
        double[] numbers = extractNumbers(expression);

        return calculateResult(numbers, operators);
    }

        //Level 3
        public double evaluateWithDifferentPrecedences(String expression) {
        expression = expression.replaceAll("\\s", "");

        if (isInvalidExpression(expression)){
            System.out.println("Invalid input - 0.0 returned");
            return 0.0;
        }
        String[] operators = expression.split("\\d+(\\.\\d+)?");
        double[] numbers = extractNumbers(expression);

            /* Scans for operators of higher precedence (*, /) and calculates those terms first,
         * replaces the first number in the term with the result, then removes the second one as well as the operator,
         * making the arrays one element shorter.
            */
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

        return calculateResult(numbers, operators);
    }

    private boolean isInvalidExpression(String expression){
        return expression.substring(0, 1).matches("\\D") ||
                expression.substring(expression.length()-1).matches("\\D") ||
                expression.matches(".*[a-zA-Z].*") ||
                expression.matches("\\d+\\.\\d*\\..*") ||
                expression.matches(".*\\D{2,}.*");
    }

    private double[] extractNumbers(String expression){
        String[] numberStrings = expression.split("[^0-9.]+");
        double[] numbers = new double[numberStrings.length];
        for (int i = 0; i < numberStrings.length; i++) {
                numbers[i] = Double.parseDouble(numberStrings[i]);
        }
        return numbers;
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

    private double calculateResult(double[] numbers, String[] operators){
        double result = numbers[0];
        for (int i = 1; i < operators.length+1 - 1; i++) {
            result = calculateTerms(operators[i], result, numbers[i]);
        }
        return result;
    }
}

package com.johanastrom.userinteraction;

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
        String userInput = "";
        while (loop) {
            System.out.println("Select a calculator; Press \"x\" to exit.\n" +
                    "Level 1 (one operator, two numericals) - press 1\n" +
                    "Level 2 (multiple terms of the same precedence) - press 2\n" +
                    "Level 3 (multiple terms of any precedence) - press 3\n");

            userInput = sc.nextLine();
            if (userInput.equalsIgnoreCase("x")) {
                System.out.println("\n============** Good Bye! **============\n");
                break;
            }

            boolean insideLoop = true;
            while (insideLoop) {
                if (!userInput.matches("[123]")) {
                    System.out.println("\nInvalid calculator choice - try again!\n");
                    insideLoop = false;
                    break;
                }
                System.out.println("Enter a mathematical expression to evaluate; press \"x\" to choose a different calculator.");
                String userExpression = sc.nextLine();
                if (userExpression.equalsIgnoreCase("x")) {
                    insideLoop = false;
                    break;
                }
                double result = 0;
                switch (userInput){
                    case "1":
                        result = calc.evaluateOneTerm(userExpression);
                                break;
                    case "2":
                        result = calc.evaluateWithSamePrecedence(userExpression);
                                break;
                    case "3":
                        result = calc.evaluateWithDifferentPrecedences(userExpression);
                        break;
                }
                System.out.println("Result: " + result + "\n");

            }

        }

    }
}

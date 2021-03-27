import com.johanastrom.Calculator;

import java.util.Scanner;

/**
 * Johan Åström 26/3 2021
 */

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static Calculator calc = new Calculator();

    public static void main(String[] args) {

        menu();

    }

    public static void menu() {
        System.out.println("============** Johan Åström - Programming Test **============\n");
        boolean loop = true;
        while (loop) {
            System.out.println("Enter a mathematical expression to evaluate; press \"x\" to exit.");
            String userInput = sc.nextLine();
            if (userInput.equalsIgnoreCase("x")) {
                loop = false;
                break;
            }
            double result = calc.evaluate(userInput);
            System.out.println("Result: " + result + "\n");
        }

    }
}

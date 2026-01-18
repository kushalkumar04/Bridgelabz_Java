package coreprogramming.controlflow.level3;

import java.util.Scanner;

/*
 * CalculatorUsingSwitch
 * ---------------------
 * This program performs basic arithmetic operations (Addition, Subtraction,
 * Multiplication, Division) using switch...case.
 * The operator is taken as a String: "+", "-", "*" or "/".
 */
public class CalculatorUsingSwitc {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Taking first number input
        System.out.print("Enter first number: ");
        double first = input.nextDouble();

        // Taking second number input
        System.out.print("Enter second number: ");
        double second = input.nextDouble();

        // Taking operator input
        System.out.print("Enter operator (+, -, *, /): ");
        String op = input.next();

        // Switch case to perform calculation based on operator
        switch (op) {

            case "+":
                System.out.println("Result = " + (first + second));
                break;

            case "-":
                System.out.println("Result = " + (first - second));
                break;

            case "*":
                System.out.println("Result = " + (first * second));
                break;

            case "/":
                if (second != 0) {
                    System.out.println("Result = " + (first / second));
                } else {
                    System.out.println("Division by zero is not allowed");
                }
                break;

            default:
                System.out.println("Invalid Operator");
        }
    }
}

package coreprogramming.controlflow.level2;

import java.util.Scanner;

/*
 * This class calculates the bonus of an employee based on years of service.
 * If the employee has more than 5 years of service, a bonus of 5% of the salary
 * is calculated and displayed. Otherwise, it prints that there is no bonus.
 */
public class SalaryOffEmployee {

    public static void main(String[] args) {

        // Create Scanner object to read input from the user
        Scanner input = new Scanner(System.in);

        // Read the employee's salary
        int salary = input.nextInt();

        // Read the number of years of service
        int years = input.nextInt();

        // Check if the employee has more than 5 years of service
        if (years > 5) {

            // Calculate 5% bonus on the salary
            double bonus = salary * 0.05;

            // Print the bonus amount
            System.out.println(bonus);
        }
        else {
            // If service is 5 years or less, no bonus is given
            System.out.println("No bonus");
        }
    }
}
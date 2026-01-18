package coreprogramming.arrays.level2;
import java.util.Scanner;

/*
 * ZaraEmployeeBonus
 * -----------------
 * This program calculates the bonus for 10 employees of Zara based on
 * their years of service and computes:
 * 1. Bonus amount for each employee
 * 2. New salary after bonus
 * 3. Total bonus payout
 * 4. Total old salary and total new salary
 *
 * Bonus Rules:
 * - More than 5 years of service  -> 5% bonus
 * - 5 years or less of service   -> 2% bonus
 */
public class ZaraEmployeeBonus {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Arrays to store salary and years of service
        double[] salary = new double[10];
        double[] yearsOfService = new double[10];

        // Arrays to store bonus and new salary
        double[] bonus = new double[10];
        double[] newSalary = new double[10];

        // Variables to store totals
        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        // Input loop for 10 employees
        System.out.println("Enter details of 10 employees:");

        for (int i = 0; i < 10; i++) {

            System.out.println("\nEmployee " + (i + 1));

            System.out.print("Enter Salary: ");
            salary[i] = input.nextDouble();

            System.out.print("Enter Years of Service: ");
            yearsOfService[i] = input.nextDouble();

            // Validation check
            if (salary[i] <= 0 || yearsOfService[i] < 0) {
                System.out.println("Invalid input! Please enter again.");
                i--; // Decrement index to repeat input for same employee
                continue;
            }
        }

        // Calculation loop
        for (int i = 0; i < 10; i++) {

            // Calculate bonus based on years of service
            if (yearsOfService[i] > 5) {
                bonus[i] = salary[i] * 0.05;  // 5% bonus
            } else {
                bonus[i] = salary[i] * 0.02;  // 2% bonus
            }

            // Calculate new salary
            newSalary[i] = salary[i] + bonus[i];

            // Add to totals
            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }

        // Display final results
        System.out.println("\n----- Zara Bonus Summary -----");
        System.out.println("Total Old Salary of all employees = " + totalOldSalary);
        System.out.println("Total Bonus to be paid = " + totalBonus);
        System.out.println("Total New Salary after Bonus = " + totalNewSalary);
    }
}

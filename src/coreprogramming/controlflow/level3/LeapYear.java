package coreprogramming.controlflow.level3;

import java.util.Scanner;

/*
 * LeapYear
 * --------
 * This program checks whether a given year is a Leap Year or not.
 * It works only for years >= 1582 (Gregorian Calendar).
 * A year is a Leap Year if:
 *  - It is divisible by 4 AND not divisible by 100
 *    OR
 *  - It is divisible by 400
 */
public class LeapYear {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = input.nextInt();

        System.out.println("----- Using Multiple if-else Statements -----");

        // Check if the year is valid (Gregorian calendar starts from 1582)
        if (year < 1582) {
            System.out.println("Leap Year check is valid only for year >= 1582");
        }
        else {
            // Condition 1: Divisible by 400 -> Leap Year
            if (year % 400 == 0) {
                System.out.println(year + " is a Leap Year");
            }
            // Condition 2: Divisible by 100 but not by 400 -> Not a Leap Year
            else if (year % 100 == 0) {
                System.out.println(year + " is NOT a Leap Year");
            }
            // Condition 3: Divisible by 4 but not by 100 -> Leap Year
            else if (year % 4 == 0) {
                System.out.println(year + " is a Leap Year");
            }
            // Otherwise -> Not a Leap Year
            else {
                System.out.println(year + " is NOT a Leap Year");
            }
        }

        System.out.println("\n----- Using Single if Statement with Logical Operators -----");

        // Single if condition using logical operators
        if (year >= 1582 && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))) {
            System.out.println(year + " is a Leap Year");
        }
        else if (year >= 1582) {
            System.out.println(year + " is NOT a Leap Year");
        }
        else {
            System.out.println("Leap Year check is valid only for year >= 1582");
        }
    }
}

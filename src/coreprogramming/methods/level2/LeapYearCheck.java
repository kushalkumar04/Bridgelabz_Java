package coreprogramming.methods.level2;
import java.util.Scanner;

/*
 * LeapYearCheck
 * -------------
 * This program checks whether a given year is a Leap Year or not.
 * It works only for years >= 1582 (Gregorian Calendar).
 * A year is a Leap Year if:
 * - It is divisible by 4 and not divisible by 100
 *   OR
 * - It is divisible by 400
 */
public class LeapYearCheck {

    // Method to check Leap Year
    public static boolean isLeapYear(int year) {

        if (year >= 1582 && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Taking input for year
        System.out.print("Enter a year: ");
        int year = input.nextInt();

        // Calling the method
        boolean result = isLeapYear(year);

        // Displaying the result
        if (result) {
            System.out.println(year + " is a Leap Year");
        } else {
            System.out.println(year + " is NOT a Leap Year");
        }
    }
}

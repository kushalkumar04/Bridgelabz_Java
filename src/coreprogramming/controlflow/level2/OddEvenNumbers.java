package coreprogramming.controlflow.level2;


import java.util.Scanner;

            /*
             * This class prints whether each number from 1 to a given number
             * is even or odd. It takes a positive integer as input and uses
             * a loop with conditional checks to determine the nature of each number.
             */
            public class OddEvenNumbers {

                public static void main(String[] args) {

                    // Create Scanner object to take input from the user
                    Scanner input = new Scanner(System.in);

                    // Read the number up to which even and odd numbers are to be checked
                    int number = input.nextInt();

                    // Check if the entered number is a positive natural number
                    if (number > 0) {

                        // Loop from 1 to the given number
                        for (int i = 1; i <= number; i++) {

                            // Check if the current number is even
                            if (i % 2 == 0) {
                                System.out.println(i + " is an even number");
                            }
                            // Otherwise, the number is odd
                            else {
                                System.out.println(i + " is an odd number");
                            }
                        }
                    }
                    else {
                        // Display message if the user enters a non-natural number
                        System.out.println("Enter a natural number");
                    }

                    // Close the Scanner to release system resources
                    input.close();
                }
            }


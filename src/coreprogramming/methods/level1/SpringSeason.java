package coreprogramming.methods.level1;

/*
 * SpringSeason
 * ------------
 * This program takes month and day from the command line
 * and checks whether the given date falls in the Spring Season.
 * Spring Season: March 20 to June 20
 */
public class SpringSeason {

    // Method to check if the given date is in Spring Season
    public static boolean isSpringSeason(int month, int day) {

        if ((month == 3 && day >= 20) ||
                (month == 4) ||
                (month == 5) ||
                (month == 6 && day <= 20)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        // Taking input from command line
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);

        // Call the method
        boolean result = isSpringSeason(month, day);

        // Display the result
        if (result) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}

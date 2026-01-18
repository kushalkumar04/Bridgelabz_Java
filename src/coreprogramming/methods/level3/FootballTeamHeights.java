package coreprogramming.methods.level3;
import java.util.Random;

/*
 * FootballTeamHeights
 * -------------------
 * This program generates random heights (3-digit, between 150 cm and 250 cm)
 * for 11 football players and finds:
 * 1. Sum of heights
 * 2. Mean height
 * 3. Shortest height
 * 4. Tallest height
 */
public class FootballTeamHeights {

    // Method to find sum of heights
    public static int findSum(int[] heights) {
        int sum = 0;
        for (int i = 0; i < heights.length; i++) {
            sum += heights[i];
        }
        return sum;
    }

    // Method to find mean height
    public static double findMean(int[] heights) {
        int sum = findSum(heights);
        return (double) sum / heights.length;
    }

    // Method to find shortest height
    public static int findShortest(int[] heights) {
        int min = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] < min) {
                min = heights[i];
            }
        }
        return min;
    }

    // Method to find tallest height
    public static int findTallest(int[] heights) {
        int max = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > max) {
                max = heights[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {

        int[] heights = new int[11];
        Random random = new Random();

        // Generate random heights between 150 and 250
        for (int i = 0; i < heights.length; i++) {
            heights[i] = 150 + random.nextInt(101); // 150 to 250
        }

        // Display generated heights
        System.out.println("Heights of 11 Football Players (in cm):");
        for (int h : heights) {
            System.out.print(h + " ");
        }

        // Calculations
        int sum = findSum(heights);
        double mean = findMean(heights);
        int shortest = findShortest(heights);
        int tallest = findTallest(heights);

        // Display results
        System.out.println("\n\nResults:");
        System.out.println("Sum of Heights     = " + sum + " cm");
        System.out.println("Mean Height        = " + mean + " cm");
        System.out.println("Shortest Height    = " + shortest + " cm");
        System.out.println("Tallest Height     = " + tallest + " cm");
    }
}

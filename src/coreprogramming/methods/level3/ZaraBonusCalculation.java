package coreprogramming.methods.level3;
/*
 * ZaraBonusCalculation
 * --------------------
 * This program calculates the bonus and new salary for 10 employees of Zara
 * based on their years of service and displays the total old salary,
 * total bonus, and total new salary in tabular format.
 */
public class ZaraBonusCalculation {

    // Method to generate salary and years of service using Math.random()
    public static double[][] generateEmployeeData(int n) {

        double[][] data = new double[n][2]; // [salary][years of service]

        for (int i = 0; i < n; i++) {
            // Generate 5-digit salary between 10000 and 99999
            data[i][0] = 10000 + Math.random() * 90000;

            // Generate years of service between 1 and 10
            data[i][1] = 1 + Math.random() * 10;
        }

        return data;
    }

    // Method to calculate bonus and new salary
    public static double[][] calculateBonusAndNewSalary(double[][] data) {

        double[][] result = new double[data.length][2]; // [bonus][new salary]

        for (int i = 0; i < data.length; i++) {

            double salary = data[i][0];
            double years = data[i][1];
            double bonus;

            if (years > 5) {
                bonus = salary * 0.05; // 5% bonus
            } else {
                bonus = salary * 0.02; // 2% bonus
            }

            double newSalary = salary + bonus;

            result[i][0] = bonus;
            result[i][1] = newSalary;
        }

        return result;
    }

    // Method to calculate totals and display in tabular format
    public static void displaySummary(double[][] data, double[][] result) {

        double totalOldSalary = 0;
        double totalBonus = 0;
        double totalNewSalary = 0;

        System.out.println("Emp\tOld Salary\tYears\tBonus\t\tNew Salary");
        System.out.println("------------------------------------------------------------");

        for (int i = 0; i < data.length; i++) {

            double salary = data[i][0];
            double years = data[i][1];
            double bonus = result[i][0];
            double newSalary = result[i][1];

            totalOldSalary += salary;
            totalBonus += bonus;
            totalNewSalary += newSalary;

            System.out.printf("%d\t%.2f\t%.1f\t%.2f\t%.2f\n",
                    (i + 1), salary, years, bonus, newSalary);
        }

        System.out.println("------------------------------------------------------------");
        System.out.printf("TOTAL\t%.2f\t\t\t%.2f\t%.2f\n",
                totalOldSalary, totalBonus, totalNewSalary);
    }

    public static void main(String[] args) {

        int numberOfEmployees = 10;

        // Step 1: Generate salary and years of service
        double[][] employeeData = generateEmployeeData(numberOfEmployees);

        // Step 2: Calculate bonus and new salary
        double[][] bonusData = calculateBonusAndNewSalary(employeeData);

        // Step 3: Display all results in table
        displaySummary(employeeData, bonusData);
    }
}

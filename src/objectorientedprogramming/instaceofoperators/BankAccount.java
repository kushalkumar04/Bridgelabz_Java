
package objectorientedprogramming.instaceofoperators;
/*
 * BankAccount class demonstrates:
 * static, this, final, and instanceof keywords
 */

public class BankAccount {

    // Static variable shared across all accounts
    static String bankName = "National Bank";
    static int totalAccounts = 0;

    // Final variable - cannot be changed once assigned
    final int accountNumber;

    // Instance variable
    String accountHolderName;

    // Constructor using 'this' keyword
    BankAccount(String accountHolderName, int accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++;
    }

    // Static method
    static void getTotalAccounts() {
        System.out.println("Total Accounts: " + totalAccounts);
    }

    // Method to display account details using instanceof
    void displayDetails(Object obj) {
        if (obj instanceof BankAccount) {
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
        }
    }

    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Alice", 101);
        acc1.displayDetails(acc1);
        BankAccount.getTotalAccounts();
    }
}

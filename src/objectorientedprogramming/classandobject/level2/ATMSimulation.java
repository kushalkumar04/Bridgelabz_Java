package objectorientedprogramming.classandobject.level2;

/*
 * This class represents a Bank Account and simulates basic ATM operations.
 * It stores account holder details and balance, and provides methods
 * to deposit money, withdraw money (with balance check), and
 * display the current account balance.
 */
class BankAccount {

    // Instance variables to store account details
    String accountHolder;
    long accountNumber;
    double balance;

    // Method to deposit money into the account
    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Deposited Amount: INR " + amount);
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance = balance - amount;
            System.out.println("Withdrawn Amount: INR " + amount);
        } else {
            System.out.println("Insufficient Balance. Withdrawal Failed.");
        }
    }

    // Method to display the current balance
    public void displayBalance() {
        System.out.println("Current Balance: INR " + balance);
    }
}

/*
 * This class contains the main method to simulate ATM operations
 * using the BankAccount class.
 */
public class ATMSimulation {

    public static void main(String[] args) {

        // Create an object of BankAccount
        BankAccount account = new BankAccount();

        // Assign account details
        account.accountHolder = "Kushal Kumar";
        account.accountNumber = 1234567890L;
        account.balance = 10000.0;

        // Display initial balance
        account.displayBalance();

        // Deposit money
        account.deposit(3000);

        // Withdraw money
        account.withdraw(5000);

        // Display final balance
        account.displayBalance();
    }
}

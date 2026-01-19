package objectorientedprogramming.inheritance.hierarchialinheritence;
/*
 * Bank Account Types System
 *
 * Demonstrates hierarchical inheritance.
 * BankAccount is the superclass.
 * SavingsAccount, CheckingAccount, and FixedDepositAccount
 * are subclasses that inherit from BankAccount.
 */

class BankAccount {

    // Common attributes for all bank accounts
    int accountNumber;
    double balance;

    // Constructor to initialize common fields
    BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Method to display basic account details
    void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

/*
 * SavingsAccount class
 *
 * Represents a savings account with an interest rate.
 */
class SavingsAccount extends BankAccount {

    double interestRate;

    SavingsAccount(int accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    // Method specific to SavingsAccount
    void displayAccountType() {
        System.out.println("Account Type: Savings Account");
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

/*
 * CheckingAccount class
 *
 * Represents a checking account with a withdrawal limit.
 */
class CheckingAccount extends BankAccount {

    double withdrawalLimit;

    CheckingAccount(int accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    // Method specific to CheckingAccount
    void displayAccountType() {
        System.out.println("Account Type: Checking Account");
        System.out.println("Withdrawal Limit: " + withdrawalLimit);
    }
}

/*
 * FixedDepositAccount class
 *
 * Represents a fixed deposit account with a lock-in period.
 */
class FixedDepositAccount extends BankAccount {

    int lockInPeriod; // in months

    FixedDepositAccount(int accountNumber, double balance, int lockInPeriod) {
        super(accountNumber, balance);
        this.lockInPeriod = lockInPeriod;
    }

    // Method specific to FixedDepositAccount
    void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
        System.out.println("Lock-in Period: " + lockInPeriod + " months");
    }
}

public class BankAccountTypes {

    public static void main(String[] args) {

        SavingsAccount sa = new SavingsAccount(101, 50000, 4.5);
        CheckingAccount ca = new CheckingAccount(102, 30000, 10000);
        FixedDepositAccount fd = new FixedDepositAccount(103, 100000, 24);

        sa.displayAccountDetails();
        sa.displayAccountType();
        System.out.println();

        ca.displayAccountDetails();
        ca.displayAccountType();
        System.out.println();

        fd.displayAccountDetails();
        fd.displayAccountType();
    }
}
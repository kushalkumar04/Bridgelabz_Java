package regexandjunit;
/*
 * JUnit test class for BankAccount.
 * It verifies deposit, withdrawal,
 * and insufficient funds behavior.
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    @Test
    void testDeposit() {
        BankAccount account = new BankAccount(1000);
        account.deposit(500);
        assertEquals(1500, account.getBalance());
    }

    @Test
    void testWithdrawSuccess() {
        BankAccount account = new BankAccount(1000);
        account.withdraw(400);
        assertEquals(600, account.getBalance());
    }

    @Test
    void testWithdrawInsufficientFunds() {
        BankAccount account = new BankAccount(500);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(1000));
    }
}

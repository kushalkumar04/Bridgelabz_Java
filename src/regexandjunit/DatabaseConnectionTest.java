package regexandjunit;

/*
 * JUnit test class demonstrating @BeforeEach and @AfterEach.
 * It ensures the database connection is created before each test
 * and closed after each test.
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class DatabaseConnectionTest {

    DatabaseConnection db;

    @BeforeEach
    void setUp() {
        db = new DatabaseConnection();
        db.connect();
    }

    @AfterEach
    void tearDown() {
        db.disconnect();
    }

    @Test
    void testConnectionEstablished() {
        assertTrue(db.isConnected());
    }

    @Test
    void testConnectionStillActiveDuringTest() {
        assertTrue(db.isConnected());
    }
}

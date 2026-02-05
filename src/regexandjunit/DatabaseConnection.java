package regexandjunit;

/*
 * This class simulates a simple database connection.
 * It provides methods to connect and disconnect,
 * and allows checking the connection status.
 */
public class DatabaseConnection {

    private boolean connected = false;

    public void connect() {
        connected = true;
        System.out.println("Database connected");
    }

    public void disconnect() {
        connected = false;
        System.out.println("Database disconnected");
    }

    public boolean isConnected() {
        return connected;
    }
}


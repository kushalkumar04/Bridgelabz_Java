package designpatterns;
/*
 * This program demonstrates the Singleton Design Pattern.
 * The Logger class ensures only one instance is created.
 * The constructor is private and access is controlled
 * through a public static getInstance() method.
 */

class Logger {

    private static Logger instance; // Single static instance variable

    private Logger() { // Private constructor prevents external instantiation
        System.out.println("Logger instance created.");
    }

    public static Logger getInstance() { // Global access point
        if (instance == null) { // Create instance only once
            instance = new Logger();
        }
        return instance; // Return the same instance
    }

    public void log(String message) { // Logging method
        System.out.println("LOG: " + message);
    }
}

public class SingletonDemo {

    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance(); // First call
        logger1.log("First message");

        Logger logger2 = Logger.getInstance(); // Second call
        logger2.log("Second message");

        System.out.println("Are both instances same? " + (logger1 == logger2)); // Verify singleton
    }
}
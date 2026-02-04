package exceptions;

/*
 * This program demonstrates the use of throw and throws keywords.
 * It simulates a user registration service and handles
 * custom exceptions related to user existence.
 */
import java.util.*;

// Custom exception: User already exists
class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}

// Custom exception: User not found
class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}

class UserService {

    // Simulated user database
    private static Set<String> users = new HashSet<>();

    // Method to register user
    public static void registerUser(String username) throws UserAlreadyExistsException {
        if (users.contains(username)) {
            throw new UserAlreadyExistsException("User already exists: " + username);
        }
        users.add(username);
        System.out.println("User registered successfully: " + username);
    }

    // Method to check if user exists
    public static void checkUserExistence(String username) throws UserNotFoundException {
        if (!users.contains(username)) {
            throw new UserNotFoundException("User not found: " + username);
        }
        System.out.println("User exists: " + username);
    }
}

public class ThrowAndThrowsExample {

    public static void main(String[] args) {

        try {
            UserService.registerUser("kushal");
            UserService.registerUser("kushal"); // duplicate user
        }
        catch (UserAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        try {
            UserService.checkUserExistence("kushal");
            UserService.checkUserExistence("rahul"); // user not found
        }
        catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

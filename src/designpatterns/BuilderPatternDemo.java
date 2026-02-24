package designpatterns;

/*
 * This program demonstrates the Builder Design Pattern.
 * The User class contains private fields and a private constructor.
 * Object creation is handled through a static inner Builder class,
 * allowing step-by-step construction of immutable objects.
 */

class User {

    private String name; // Private field for name
    private int age; // Private field for age
    private String email; // Private field for email

    private User(Builder builder) { // Private constructor accepts Builder
        this.name = builder.name;
        this.age = builder.age;
        this.email = builder.email;
    }

    public void display() { // Method to display user details
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
    }

    static class Builder {

        private String name; // Builder field for name
        private int age; // Builder field for age
        private String email; // Builder field for email

        public Builder setName(String name) { // Setter-like method
            this.name = name;
            return this; // Return Builder for method chaining
        }

        public Builder setAge(int age) { // Setter-like method
            this.age = age;
            return this; // Return Builder for method chaining
        }

        public Builder setEmail(String email) { // Setter-like method
            this.email = email;
            return this; // Return Builder for method chaining
        }

        public User build() { // Build method creates User object
            return new User(this);
        }
    }
}

public class BuilderPatternDemo {

    public static void main(String[] args) {

        User user = new User.Builder() // Create Builder instance
                .setName("Kushal") // Set name
                .setAge(22) // Set age
                .setEmail("kushal@example.com") // Set email
                .build(); // Build final User object

        user.display(); // Display user details
    }
}
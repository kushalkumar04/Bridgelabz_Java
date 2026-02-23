package reflection;

/*
 * Demonstrates how to access and modify
 * a private field using Java Reflection API.
 */

import java.lang.reflect.Field;

// Person class with private field
class Person {

    // Private field
    private int age;

    // Constructor
    public Person(int age) {
        this.age = age;
    }
}

public class PrivateFieldAccess {

    public static void main(String[] args) {

        try {
            // Create object of Person
            Person person = new Person(25);

            // Get Class object
            Class<?> clazz = person.getClass();

            // Get the private field "age"
            Field field = clazz.getDeclaredField("age");

            // Make the private field accessible
            field.setAccessible(true);

            // Retrieve current value of age
            int currentAge = (int) field.get(person);
            System.out.println("Original Age: " + currentAge);

            // Modify the private field value
            field.set(person, 30);

            // Retrieve modified value
            int modifiedAge = (int) field.get(person);
            System.out.println("Modified Age: " + modifiedAge);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

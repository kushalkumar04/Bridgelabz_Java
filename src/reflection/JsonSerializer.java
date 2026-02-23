package reflection;

/*
 * JsonSerializer is a utility class that converts a Java object
 * into a JSON-like string representation using Reflection.
 * It dynamically inspects object fields at runtime and extracts
 * their names and corresponding values without using external libraries.
 */

import java.lang.reflect.Field;

public class JsonSerializer {

    /**
     * Converts any object into a JSON-like string.
     *
     * @param obj The object to be converted.
     * @return    JSON-like string representation of the object.
     */
    public static String toJson(Object obj) {

        // Handle null input
        if (obj == null) {
            return "null";
        }

        StringBuilder jsonBuilder = new StringBuilder();
        Class<?> clazz = obj.getClass();  // Get runtime class of the object

        jsonBuilder.append("{");

        // Get all declared fields (including private fields)
        Field[] fields = clazz.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {

            Field field = fields[i];

            // Allow access to private fields
            field.setAccessible(true);

            try {
                // Get field name
                String fieldName = field.getName();

                // Get field value from the object
                Object value = field.get(obj);

                jsonBuilder.append("\"").append(fieldName).append("\":");

                // Handle String values with quotes
                if (value instanceof String) {
                    jsonBuilder.append("\"").append(value).append("\"");
                }
                // Handle null values
                else if (value == null) {
                    jsonBuilder.append("null");
                }
                // Handle primitive types and other objects
                else {
                    jsonBuilder.append(value);
                }

                // Add comma if not the last field
                if (i < fields.length - 1) {
                    jsonBuilder.append(",");
                }

            } catch (IllegalAccessException e) {
                throw new RuntimeException("Error accessing field value", e);
            }
        }

        jsonBuilder.append("}");

        return jsonBuilder.toString();
    }

    // Example usage
    public static void main(String[] args) {

        // Sample test object
        Person person = new Person("Kushal", 22, true);

        // Convert object to JSON-like string
        String json = JsonSerializer.toJson(person);

        System.out.println(json);
    }
}

/*
 * Person is a sample model class used to demonstrate
 * JSON serialization using Reflection.
 */
class Person {

    private String name;
    private int age;
    private boolean isStudent;

    public Person(String name, int age, boolean isStudent) {
        this.name = name;
        this.age = age;
        this.isStudent = isStudent;
    }
}
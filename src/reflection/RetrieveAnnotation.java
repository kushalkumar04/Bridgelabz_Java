package reflection;

/*
 * This program demonstrates how to create a custom annotation
 * and retrieve its value at runtime using Reflection.
 */

import java.lang.annotation.*;
import java.lang.reflect.*;

// Step 1: Define Custom Annotation
@Retention(RetentionPolicy.RUNTIME)   // Available at runtime
@Target(ElementType.TYPE)              // Can be applied to class
@interface Author {
    String name();
}

// Step 2: Apply Annotation to a Class
@Author(name = "Kushal Kumar")
class BookService {
    public void display() {
        System.out.println("Book Service Class");
    }
}

// Step 3: Retrieve Annotation at Runtime
public class RetrieveAnnotation {

    public static void main(String[] args) {

        try {
            Class<?> clazz = BookService.class;

            if (clazz.isAnnotationPresent(Author.class)) {
                Author author = clazz.getAnnotation(Author.class);
                System.out.println("Author Name: " + author.name());
            } else {
                System.out.println("No Author annotation found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
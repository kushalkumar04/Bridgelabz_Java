package annotations;

/*
 * This program demonstrates a custom annotation @ImportantMethod
 * with a default level parameter and retrieves annotated methods
 * at runtime using Reflection API.
 */

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME) // Make annotation available at runtime
@Target(ElementType.METHOD) // Allow usage only on methods
@interface ImportantMethod {
    String level() default "HIGH"; // Optional parameter with default value
}

class SampleService {

    @ImportantMethod // Uses default level HIGH
    public void criticalTask() {
        System.out.println("Executing critical task...");
    }

    @ImportantMethod(level = "MEDIUM") // Custom level provided
    public void moderateTask() {
        System.out.println("Executing moderate task...");
    }

    public void normalTask() {
        System.out.println("Executing normal task...");
    }
}

public class ImportantMethodDemo {

    public static void main(String[] args) {

        Class<SampleService> clazz = SampleService.class; // Get class object

        for (Method method : clazz.getDeclaredMethods()) { // Iterate methods

            if (method.isAnnotationPresent(ImportantMethod.class)) { // Check annotation

                ImportantMethod annotation =
                        method.getAnnotation(ImportantMethod.class); // Get annotation instance

                System.out.println("Method: " + method.getName()); // Print method name
                System.out.println("Level: " + annotation.level()); // Print importance level
                System.out.println("-------------------");
            }
        }
    }
}
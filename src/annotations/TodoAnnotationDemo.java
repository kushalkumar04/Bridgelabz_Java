package annotations;

/*
 * This program demonstrates a custom @Todo annotation
 * used to mark pending tasks in a project.
 * It retrieves and displays task metadata at runtime
 * using the Reflection API.
 */

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME) // Make annotation available at runtime
@Target(ElementType.METHOD) // Restrict usage to methods
@interface Todo {
    String task(); // Description of the task
    String assignedTo(); // Developer responsible
    String priority() default "MEDIUM"; // Default priority
}

class ProjectModule {

    @Todo(task = "Implement login feature", assignedTo = "Kushal", priority = "HIGH")
    public void loginFeature() {
        System.out.println("Login feature pending...");
    }

    @Todo(task = "Add validation to signup form", assignedTo = "Rahul")
    public void signupValidation() {
        System.out.println("Signup validation pending...");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Anjali", priority = "LOW")
    public void optimizeDatabase() {
        System.out.println("Database optimization pending...");
    }

    public void completedFeature() {
        System.out.println("This feature is completed.");
    }
}

public class TodoAnnotationDemo {

    public static void main(String[] args) {

        Class<ProjectModule> clazz = ProjectModule.class; // Get class object

        for (Method method : clazz.getDeclaredMethods()) { // Iterate through methods

            if (method.isAnnotationPresent(Todo.class)) { // Check for @Todo annotation

                Todo todo = method.getAnnotation(Todo.class); // Retrieve annotation instance

                System.out.println("Method Name: " + method.getName()); // Print method name
                System.out.println("Task: " + todo.task()); // Print task description
                System.out.println("Assigned To: " + todo.assignedTo()); // Print developer name
                System.out.println("Priority: " + todo.priority()); // Print priority
                System.out.println("----------------------------------");
            }
        }
    }
}
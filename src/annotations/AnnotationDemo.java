package annotations;

/*
 * This program demonstrates creation of a custom annotation
 * named @TaskInfo and retrieving its values using Reflection.
 * The annotation stores metadata like priority and assigned person.
 * Reflection API is used to inspect annotation details at runtime.
 */

import java.lang.annotation.*;
import java.lang.reflect.Method;


/*---------------------------------------------------
  Step 1: Define Custom Annotation
---------------------------------------------------*/

// Make annotation available at runtime
@Retention(RetentionPolicy.RUNTIME)

// Annotation can be applied to methods only
@Target(ElementType.METHOD)
@interface TaskInfo {

    String priority();     // Priority level of task

    String assignedTo();   // Person assigned to the task
}


/*---------------------------------------------------
  Step 2: Apply Annotation in a Class
---------------------------------------------------*/

/*
 * TaskManager contains a method annotated with @TaskInfo.
 * The annotation stores metadata about the task.
 */
class TaskManager {

    @TaskInfo(priority = "High", assignedTo = "Kushal")
    public void completeTask() {
        System.out.println("Task is being completed...");
    }
}


/*---------------------------------------------------
  Step 3: Retrieve Annotation Using Reflection
---------------------------------------------------*/

public class AnnotationDemo {

    public static void main(String[] args) {

        try {
            // Get TaskManager class object
            Class<TaskManager> clazz = TaskManager.class;

            // Get specific method
            Method method = clazz.getMethod("completeTask");

            // Check if annotation is present
            if (method.isAnnotationPresent(TaskInfo.class)) {

                // Retrieve annotation instance
                TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);

                // Print annotation values
                System.out.println("Priority: " + taskInfo.priority());
                System.out.println("Assigned To: " + taskInfo.assignedTo());
            }

            // Execute actual method
            TaskManager manager = new TaskManager();
            manager.completeTask();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
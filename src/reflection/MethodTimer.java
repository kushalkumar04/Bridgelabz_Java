package reflection;

/*
 * MethodTimer demonstrates how to measure execution time
 * of any method dynamically using Java Reflection.
 * It invokes a specified method at runtime and calculates
 * the total time taken for execution in nanoseconds.
 */

import java.lang.reflect.Method;

public class MethodTimer {

    /**
     * Invokes a method dynamically and measures execution time.
     *
     * @param target     Object whose method needs to be executed
     * @param methodName Name of the method to invoke
     * @param paramTypes Parameter types of the method
     * @param args       Arguments to pass to the method
     * @return           Result returned by the invoked method
     */
    public static Object measureExecutionTime(
            Object target,
            String methodName,
            Class<?>[] paramTypes,
            Object[] args) {

        try {
            // Get the runtime class of the target object
            Class<?> clazz = target.getClass();

            // Retrieve the specified method (including private if needed)
            Method method = clazz.getDeclaredMethod(methodName, paramTypes);

            // Allow invocation of private methods
            method.setAccessible(true);

            // Record start time (high precision)
            long startTime = System.nanoTime();

            // Invoke the method dynamically
            Object result = method.invoke(target, args);

            // Record end time
            long endTime = System.nanoTime();

            // Calculate total execution time
            long executionTime = endTime - startTime;

            System.out.println("Method Executed: " + methodName);
            System.out.println("Execution Time (nanoseconds): " + executionTime);

            return result;

        } catch (Exception e) {
            throw new RuntimeException("Error during method timing", e);
        }
    }
}


/*
 * SampleService is a demo class containing methods
 * whose execution time will be measured dynamically.
 */
class SampleService {

    // Method with delay simulation
    public void performTask() {
        try {
            Thread.sleep(500); // Simulate workload (500 ms)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task completed.");
    }

    // Method with return value
    public int calculateSum(int a, int b) {
        return a + b;
    }
}


/*
 * Main class to demonstrate execution timing
 * of methods using reflection.
 */
class TimingDemo {

    public static void main(String[] args) {

        SampleService service = new SampleService();

        // Measure void method execution
        MethodTimer.measureExecutionTime(
                service,
                "performTask",
                new Class<?>[]{},
                new Object[]{}
        );

        // Measure method with parameters and return value
        Object result = MethodTimer.measureExecutionTime(
                service,
                "calculateSum",
                new Class<?>[]{int.class, int.class},
                new Object[]{10, 20}
        );

        System.out.println("Returned Result: " + result);
    }
}
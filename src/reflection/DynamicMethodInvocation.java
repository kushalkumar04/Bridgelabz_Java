package reflection;

/*
 * This program demonstrates Dynamic Method Invocation using Reflection.
 * It defines a MathOperations class with multiple public methods
 * (add, subtract, multiply) and invokes the selected method
 * dynamically based on user input.
 */
import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicMethodInvocation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            MathOperations math = new MathOperations();

            System.out.print("Enter method name (add, subtract, multiply): ");
            String methodName = scanner.nextLine();

            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();

            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();

            // Get method dynamically using reflection
            Method method = MathOperations.class.getMethod(methodName, int.class, int.class);

            // Invoke method dynamically
            Object result = method.invoke(math, num1, num2);

            System.out.println("Result: " + result);

        } catch (NoSuchMethodException e) {
            System.out.println("Error: Method not found.");
        } catch (Exception e) {
            System.out.println("Error invoking method: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
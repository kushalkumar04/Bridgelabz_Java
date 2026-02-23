package reflection;

/*
 * LoggingProxy demonstrates the use of Java Dynamic Proxy
 * to intercept method calls on an interface at runtime.
 * It logs the method name before delegating execution
 * to the actual target object implementation.
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// Step 1: Define an interface
interface Greeting {
    void sayHello(String name);
}

/*
 * GreetingImpl is the concrete implementation
 * of the Greeting interface whose method calls
 * will be intercepted by the dynamic proxy.
 */
class GreetingImpl implements Greeting {

    @Override
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }
}

/*
 * LoggingInvocationHandler handles method interception.
 * It logs the method name before invoking the actual method
 * on the target object using reflection.
 */
class LoggingInvocationHandler implements InvocationHandler {

    private final Object target; // Original object being proxied

    // Constructor to initialize the target object
    public LoggingInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * This method is invoked whenever a proxied method is called.
     *
     * @param proxy  The proxy instance
     * @param method The method being called
     * @param args   Arguments passed to the method
     * @return       The result of method invocation
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // Log method name before execution
        System.out.println("Invoking method: " + method.getName());

        // Invoke actual method on the target object
        return method.invoke(target, args);
    }
}

/*
 * Main class to demonstrate dynamic proxy creation
 * and logging behavior before method execution.
 */
public class LoggingProxyDemo {

    public static void main(String[] args) {

        // Create the actual implementation object
        Greeting greeting = new GreetingImpl();

        // Create dynamic proxy instance
        Greeting proxyInstance = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),          // Class loader
                new Class[]{Greeting.class},              // Interfaces to implement
                new LoggingInvocationHandler(greeting)   // Invocation handler
        );

        // Call method via proxy (intercepted)
        proxyInstance.sayHello("Kushal");
    }
}
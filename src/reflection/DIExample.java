package reflection;


/*
 * SimpleDIContainer demonstrates a basic Dependency Injection
 * framework using Java Reflection. It scans fields annotated
 * with @Inject and dynamically creates and injects dependencies
 * at runtime without using external libraries like Spring.
 */

import java.lang.annotation.*;
import java.lang.reflect.Field;

/*---------------------------------------------------
  Step 1: Create Custom @Inject Annotation
---------------------------------------------------*/

// Retention policy RUNTIME allows reflection to detect it
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD) // Annotation can be used only on fields
@interface Inject {
}


/*---------------------------------------------------
  Step 2: Create Simple DI Container
---------------------------------------------------*/

class SimpleDIContainer {

    /**
     * Creates an instance of the given class and injects
     * all fields marked with @Inject annotation.
     *
     * @param clazz Class to instantiate
     * @param <T>   Generic type
     * @return      Fully injected object instance
     */
    public <T> T createInstance(Class<T> clazz) {

        try {
            // Create object using default constructor
            T instance = clazz.getDeclaredConstructor().newInstance();

            // Iterate through all declared fields
            for (Field field : clazz.getDeclaredFields()) {

                // Check if field has @Inject annotation
                if (field.isAnnotationPresent(Inject.class)) {

                    // Allow access to private fields
                    field.setAccessible(true);

                    // Create dependency object
                    Object dependency = field.getType()
                            .getDeclaredConstructor()
                            .newInstance();

                    // Inject dependency into field
                    field.set(instance, dependency);
                }
            }

            return instance;

        } catch (Exception e) {
            throw new RuntimeException("Dependency Injection failed", e);
        }
    }
}


/*---------------------------------------------------
  Step 3: Example Service Classes
---------------------------------------------------*/

/*
 * Engine is a dependency class that will be injected
 * into the Car class dynamically by the DI container.
 */
class Engine {
    public void start() {
        System.out.println("Engine started...");
    }
}

/*
 * Car contains a dependency marked with @Inject.
 * The DI container will automatically create and
 * inject the Engine instance at runtime.
 */
class Car {

    @Inject
    private Engine engine; // Dependency to be injected

    public void drive() {
        engine.start();  // Using injected dependency
        System.out.println("Car is moving...");
    }
}


/*---------------------------------------------------
  Step 4: Test the DI Container
---------------------------------------------------*/

public class DIExample {

    public static void main(String[] args) {

        // Create DI container
        SimpleDIContainer container = new SimpleDIContainer();

        // Request object creation with dependency injection
        Car car = container.createInstance(Car.class);

        // Use injected dependency
        car.drive();
    }
}
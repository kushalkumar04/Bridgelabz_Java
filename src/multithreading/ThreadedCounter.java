package multithreading;

/*
 * This program demonstrates a simple multi-threaded counter.
 * The user provides a limit, and multiple threads collaboratively
 * count from 1 to that limit in proper synchronized order.
 * Thread coordination is achieved using a shared Counter object.
 */

import java.util.Scanner;

class Counter {

    private int count = 1; // Shared counter starting from 1
    private final int limit; // Maximum counting limit

    public Counter(int limit) {
        this.limit = limit;
    }

    public synchronized void printNext(String threadName) {
        if (count <= limit) { // Ensure count does not exceed limit
            System.out.println(threadName + " -> " + count);
            count++; // Increment counter safely
        }
    }

    public int getCount() {
        return count;
    }

    public int getLimit() {
        return limit;
    }
}

class CountingThread extends Thread {

    private final Counter counter; // Shared counter reference

    public CountingThread(Counter counter, String name) {
        super(name); // Set thread name
        this.counter = counter;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (counter) { // Synchronize on shared object

                if (counter.getCount() > counter.getLimit()) {
                    break; // Stop if limit reached
                }

                counter.printNext(Thread.currentThread().getName()); // Print next number
            }

            try {
                Thread.sleep(50); // Small delay for better thread interleaving
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + getName());
            }
        }
    }
}

public class ThreadedCounter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter counting limit: ");
            int limit = scanner.nextInt(); // Read user input

            if (limit <= 0) { // Validate input
                System.out.println("Please enter a positive integer.");
                return;
            }

            Counter counter = new Counter(limit); // Create shared counter

            CountingThread t1 = new CountingThread(counter, "Thread-1"); // Create thread 1
            CountingThread t2 = new CountingThread(counter, "Thread-2"); // Create thread 2
            CountingThread t3 = new CountingThread(counter, "Thread-3"); // Create thread 3

            t1.start(); // Start threads
            t2.start();
            t3.start();

            t1.join(); // Wait for threads to finish
            t2.join();
            t3.join();

            System.out.println("Counting completed successfully.");

        } catch (Exception e) {
            System.out.println("Invalid input or unexpected error occurred.");
        } finally {
            scanner.close(); // Close scanner
        }
    }
}
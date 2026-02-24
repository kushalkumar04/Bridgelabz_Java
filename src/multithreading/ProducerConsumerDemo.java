package multithreading;

/*
 * This program demonstrates the Producer-Consumer problem
 * using a shared queue as a common resource.
 * The Producer thread generates integer tasks,
 * and the Consumer thread processes them using proper synchronization.
 */

import java.util.LinkedList;
import java.util.Queue;

class SharedQueue {

    private final Queue<Integer> queue = new LinkedList<>(); // Shared task queue
    private final int capacity; // Maximum queue size

    public SharedQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(int task) {

        while (queue.size() == capacity) { // Wait if queue is full
            try {
                wait(); // Release lock and wait
            } catch (InterruptedException e) {
                System.out.println("Producer interrupted.");
            }
        }

        queue.add(task); // Add task to queue
        System.out.println("Produced: " + task);

        notify(); // Notify waiting consumer
    }

    public synchronized int consume() {

        while (queue.isEmpty()) { // Wait if queue is empty
            try {
                wait(); // Release lock and wait
            } catch (InterruptedException e) {
                System.out.println("Consumer interrupted.");
            }
        }

        int task = queue.poll(); // Remove task from queue
        System.out.println("Consumed: " + task);

        notify(); // Notify waiting producer
        return task;
    }
}

class Producer extends Thread {

    private final SharedQueue sharedQueue;

    public Producer(SharedQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) { // Generate 10 tasks
                sharedQueue.produce(i);
                Thread.sleep(100); // Simulate production delay
            }
        } catch (Exception e) {
            System.out.println("Error in Producer thread.");
        }
    }
}

class Consumer extends Thread {

    private final SharedQueue sharedQueue;

    public Consumer(SharedQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) { // Consume 10 tasks
                sharedQueue.consume();
                Thread.sleep(150); // Simulate processing delay
            }
        } catch (Exception e) {
            System.out.println("Error in Consumer thread.");
        }
    }
}

public class ProducerConsumerDemo {

    public static void main(String[] args) {

        SharedQueue sharedQueue = new SharedQueue(5); // Create shared queue with capacity 5

        Producer producer = new Producer(sharedQueue); // Create producer thread
        Consumer consumer = new Consumer(sharedQueue); // Create consumer thread

        producer.start(); // Start producer
        consumer.start(); // Start consumer

        try {
            producer.join(); // Wait for producer to finish
            consumer.join(); // Wait for consumer to finish
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("Producer-Consumer execution completed.");
    }
}
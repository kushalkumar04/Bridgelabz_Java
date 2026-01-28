package collections.queueinterface;

/*
 * This program reverses the elements of a Queue using only
 * basic queue operations like add(), remove(), and isEmpty().
 */
import java.util.*;

public class ReverseQueue {

    public static void reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        // Remove elements from queue and push to stack
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        // Pop elements from stack and add back to queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Original Queue: " + queue);

        reverseQueue(queue);

        System.out.println("Reversed Queue: " + queue);
    }
}

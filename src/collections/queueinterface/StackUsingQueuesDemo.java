package collections.queueinterface;

/*
 * This program implements a Stack using two Queues.
 * It supports push, pop, and top operations and follows
 * LIFO (Last In First Out) behavior using only queue operations.
 */
import java.util.*;

class StackUsingQueues {

    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    // Push element onto stack
    public void push(int x) {
        q1.add(x);
    }

    // Pop element from stack
    public int pop() {
        if (q1.isEmpty()) {
            return -1;
        }

        // Move all elements except last to q2
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        int popped = q1.remove(); // Last inserted element

        // Swap queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return popped;
    }

    // Get top element
    public int top() {
        if (q1.isEmpty()) {
            return -1;
        }

        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        int top = q1.peek();
        q2.add(q1.remove());

        // Swap queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return top;
    }
}

public class StackUsingQueuesDemo {

    public static void main(String[] args) {

        StackUsingQueues stack = new StackUsingQueues();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.top()); // 3
        System.out.println("Popped element: " + stack.pop()); // 3
        System.out.println("Top after pop: " + stack.top()); // 2
    }
}

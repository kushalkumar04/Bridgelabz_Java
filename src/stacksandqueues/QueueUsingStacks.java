package stacksandqueues;

import java.util.Stack;

class QueueUsingStacks {

    Stack<Integer> stackEnqueue = new Stack<>();
    Stack<Integer> stackDequeue = new Stack<>();

    // Enqueue operation
    public void enqueue(int data) {
        stackEnqueue.push(data);
        System.out.println(data + " enqueued to queue");
    }

    // Dequeue operation
    public int dequeue() {
        if (stackDequeue.isEmpty()) {
            if (stackEnqueue.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            // Transfer elements from stackEnqueue to stackDequeue
            while (!stackEnqueue.isEmpty()) {
                stackDequeue.push(stackEnqueue.pop());
            }
        }
        return stackDequeue.pop();
    }

    // Display front element
    public int peek() {
        if (stackDequeue.isEmpty()) {
            while (!stackEnqueue.isEmpty()) {
                stackDequeue.push(stackEnqueue.pop());
            }
        }
        return stackDequeue.peek();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Front element: " + queue.peek());
        System.out.println("Dequeued: " + queue.dequeue());
    }
}

package stacksandqueues;

import java.util.Stack;

class SortStackUsingRecursion {

    // Function to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();      // Remove top element
            sortStack(stack);          // Sort remaining stack
            insertAtCorrectPosition(stack, top); // Insert back correctly
        }
    }

    // Function to insert an element in sorted order
    private static void insertAtCorrectPosition(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }

        int temp = stack.pop();
        insertAtCorrectPosition(stack, element);
        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(40);
        stack.push(10);
        stack.push(30);
        stack.push(20);
        stack.push(50);

        System.out.println("Before Sorting: " + stack);

        sortStack(stack);

        System.out.println("After Sorting (Ascending): " + stack);
    }
}

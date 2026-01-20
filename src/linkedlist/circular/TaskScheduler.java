package linkedlist.circular;

/***************************************************************
 * This program implements a Task Scheduler using a Circular
 * Singly Linked List.
 *
 * Each task contains:
 *   - Task ID
 *   - Task Name
 *   - Priority
 *   - Due Date
 *
 * Supported Operations:
 * 1. Add task at beginning, end, or specific position
 * 2. Delete task by Task ID
 * 3. View current task and move to next (circular traversal)
 * 4. Display all tasks
 * 5. Search tasks by Priority
 ***************************************************************/

// Node class representing each task
class TaskNode {

    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;

    // Constructor to initialize task node
    public TaskNode(int id, String name, int priority, String dueDate) {
        this.taskId = id;
        this.taskName = name;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

/*
 * This class implements Circular Linked List operations
 * for the Task Scheduler.
 */
class CircularTaskList {

    TaskNode head = null;
    TaskNode current = null;

    // Add task at beginning
    public void addAtBeginning(int id, String name, int priority, String date) {
        TaskNode newNode = new TaskNode(id, name, priority, date);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
        } else {
            TaskNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newNode.next = head;
            temp.next = newNode;
            head = newNode;
        }
    }

    // Add task at end
    public void addAtEnd(int id, String name, int priority, String date) {
        TaskNode newNode = new TaskNode(id, name, priority, date);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
            return;
        }

        TaskNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;
    }

    // Add task at specific position (1-based index)
    public void addAtPosition(int pos, int id, String name, int priority, String date) {
        if (pos == 1) {
            addAtBeginning(id, name, priority, date);
            return;
        }

        TaskNode newNode = new TaskNode(id, name, priority, date);
        TaskNode temp = head;

        for (int i = 1; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete task by Task ID
    public void deleteById(int id) {
        if (head == null) return;

        TaskNode temp = head;
        TaskNode prev = null;

        do {
            if (temp.taskId == id) {
                if (temp == head) {
                    TaskNode last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = temp.next;
                }
                System.out.println("Task deleted successfully.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Task not found.");
    }

    // View current task and move to next
    public void viewNextTask() {
        if (current == null) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("Current Task:");
        displayTask(current);
        current = current.next;
    }

    // Display all tasks
    public void displayAll() {
        if (head == null) {
            System.out.println("No tasks in scheduler.");
            return;
        }

        TaskNode temp = head;
        do {
            displayTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // Search tasks by Priority
    public void searchByPriority(int priority) {
        if (head == null) return;

        TaskNode temp = head;
        boolean found = false;

        do {
            if (temp.priority == priority) {
                displayTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No task found with priority " + priority);
        }
    }

    // Helper method to print one task
    private void displayTask(TaskNode t) {
        System.out.println("----------------------------");
        System.out.println("Task ID   : " + t.taskId);
        System.out.println("Task Name : " + t.taskName);
        System.out.println("Priority  : " + t.priority);
        System.out.println("Due Date  : " + t.dueDate);
    }
}

/*
 * Main class to test the Circular Task Scheduler
 */
public class TaskScheduler {

    public static void main(String[] args) {

        CircularTaskList scheduler = new CircularTaskList();

        // Add tasks
        scheduler.addAtEnd(1, "Submit Assignment", 1, "20-01-2026");
        scheduler.addAtEnd(2, "Prepare Presentation", 2, "22-01-2026");
        scheduler.addAtBeginning(3, "Attend Interview", 1, "18-01-2026");

        // Insert at specific position
        scheduler.addAtPosition(2, 4, "Pay Fees", 3, "25-01-2026");

        // Display all tasks
        System.out.println("All Tasks:");
        scheduler.displayAll();

        // View current and next task (circular behavior)
        scheduler.viewNextTask();
        scheduler.viewNextTask();

        // Search by priority
        System.out.println("\nTasks with Priority 1:");
        scheduler.searchByPriority(1);

        // Delete a task
        scheduler.deleteById(2);

        // Display after deletion
        System.out.println("\nAfter Deletion:");
        scheduler.displayAll();
    }
}

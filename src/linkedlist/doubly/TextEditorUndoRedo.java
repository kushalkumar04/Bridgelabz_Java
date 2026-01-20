package linkedlist.doubly;
/***************************************************************
 * Undo / Redo Functionality using Doubly Linked List
 *
 * Each node represents a state of the text in a text editor.
 * The list maintains at most the last 10 states.
 *
 * Features:
 * 1. Add new text state
 * 2. Undo (move to previous state)
 * 3. Redo (move to next state)
 * 4. Display current text
 ***************************************************************/

// Node representing one text state
class TextStateNode {

    String content;           // Stores the text at this state
    TextStateNode prev;      // Pointer to previous state (Undo)
    TextStateNode next;      // Pointer to next state (Redo)

    public TextStateNode(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

/*
 * This class manages the Undo/Redo operations
 * using a Doubly Linked List.
 */
class TextEditorHistory {

    private TextStateNode head;     // First state
    private TextStateNode tail;     // Last state
    private TextStateNode current;  // Current state pointer
    private int size = 0;
    private final int MAX_SIZE = 10;

    // Add new text state
    public void addState(String text) {
        TextStateNode newNode = new TextStateNode(text);

        // If list is empty
        if (head == null) {
            head = tail = current = newNode;
            size++;
            return;
        }

        // Remove redo history (everything after current)
        current.next = null;
        tail = current;

        // Add new state at end
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        current = newNode;
        size++;

        // Maintain history size limit
        if (size > MAX_SIZE) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // Undo operation
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo performed.");
        } else {
            System.out.println("No more undo available.");
        }
    }

    // Redo operation
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo performed.");
        } else {
            System.out.println("No more redo available.");
        }
    }

    // Display current text state
    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current Text: " + current.content);
        } else {
            System.out.println("No text available.");
        }
    }
}

/*
 * Main class to test Undo / Redo functionality
 */
public class TextEditorUndoRedo {

    public static void main(String[] args) {

        TextEditorHistory editor = new TextEditorHistory();

        // Simulating typing
        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.addState("Hello World!!");

        // Display current state
        editor.displayCurrentState();

        // Perform Undo operations
        editor.undo();
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        // Perform Redo operation
        editor.redo();
        editor.displayCurrentState();

        // Add new state after undo (redo history cleared)
        editor.addState("Hello World!!!");
        editor.displayCurrentState();

        // Try redo again
        editor.redo();
    }
}

package linkedlist.doubly;

/***************************************************************
 * Library Management System using Doubly Linked List
 *
 * Each node (BookNode) stores:
 *  - Book ID
 *  - Title
 *  - Author
 *  - Genre
 *  - Availability Status
 *
 * Supported Operations:
 * 1. Add book at beginning, end, or specific position
 * 2. Remove book by Book ID
 * 3. Search by Title or Author
 * 4. Update Availability Status
 * 5. Display all books (forward & reverse)
 * 6. Count total number of books
 ***************************************************************/

// Node class representing each Book
class BookNode {

    int bookId;
    String title;
    String author;
    String genre;
    boolean isAvailable;

    BookNode next;
    BookNode prev;

    // Constructor
    public BookNode(int id, String title, String author, String genre, boolean status) {
        this.bookId = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = status;
        this.next = null;
        this.prev = null;
    }
}

/*
 * Doubly Linked List class implementing library operations
 */
class LibraryDoublyLinkedList {

    BookNode head;
    BookNode tail;

    // Add at beginning
    public void addAtBeginning(int id, String title, String author, String genre, boolean status) {
        BookNode newNode = new BookNode(id, title, author, genre, status);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Add at end
    public void addAtEnd(int id, String title, String author, String genre, boolean status) {
        BookNode newNode = new BookNode(id, title, author, genre, status);

        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Add at specific position (1-based index)
    public void addAtPosition(int pos, int id, String title, String author, String genre, boolean status) {
        if (pos == 1) {
            addAtBeginning(id, title, author, genre, status);
            return;
        }

        BookNode temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position.");
            return;
        }

        BookNode newNode = new BookNode(id, title, author, genre, status);

        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        } else {
            tail = newNode;
        }

        temp.next = newNode;
    }

    // Remove book by ID
    public void removeById(int id) {
        BookNode temp = head;

        while (temp != null && temp.bookId != id) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Book not found.");
            return;
        }

        if (temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
        } else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        System.out.println("Book removed successfully.");
    }

    // Search by Title
    public void searchByTitle(String title) {
        BookNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("Book not found.");
    }

    // Search by Author
    public void searchByAuthor(String author) {
        BookNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("Book not found.");
    }

    // Update availability
    public void updateAvailability(int id, boolean status) {
        BookNode temp = head;

        while (temp != null) {
            if (temp.bookId == id) {
                temp.isAvailable = status;
                System.out.println("Availability updated.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book not found.");
    }

    // Display forward
    public void displayForward() {
        BookNode temp = head;
        while (temp != null) {
            displayBook(temp);
            temp = temp.next;
        }
    }

    // Display reverse
    public void displayReverse() {
        BookNode temp = tail;
        while (temp != null) {
            displayBook(temp);
            temp = temp.prev;
        }
    }

    // Count books
    public int countBooks() {
        int count = 0;
        BookNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Helper method to display one book
    private void displayBook(BookNode b) {
        System.out.println("--------------------------------");
        System.out.println("Book ID    : " + b.bookId);
        System.out.println("Title      : " + b.title);
        System.out.println("Author     : " + b.author);
        System.out.println("Genre      : " + b.genre);
        System.out.println("Available  : " + (b.isAvailable ? "Yes" : "No"));
    }
}

/*
 * Main class to test Library Management System
 */
public class LibraryManagementSystem {

    public static void main(String[] args) {

        LibraryDoublyLinkedList library = new LibraryDoublyLinkedList();

        // Add books
        library.addAtBeginning(1, "Clean Code", "Robert Martin", "Programming", true);
        library.addAtEnd(2, "Java Complete Reference", "Herbert Schildt", "Programming", true);
        library.addAtEnd(3, "Harry Potter", "J.K. Rowling", "Fantasy", false);
        library.addAtPosition(2, 4, "Atomic Habits", "James Clear", "Self Help", true);

        // Display books
        System.out.println("Library Books (Forward):");
        library.displayForward();

        System.out.println("\nLibrary Books (Reverse):");
        library.displayReverse();

        // Search
        library.searchByTitle("Harry Potter");
        library.searchByAuthor("James Clear");

        // Update availability
        library.updateAvailability(3, true);

        // Remove a book
        library.removeById(2);

        // Count total books
        System.out.println("\nTotal Books in Library: " + library.countBooks());
    }
}

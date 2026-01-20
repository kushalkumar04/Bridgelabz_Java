package linkedlist.doubly;

/***************************************************************
 * This program implements a Movie Management System using
 * a Doubly Linked List.
 *
 * Each node stores:
 *   - Movie Title
 *   - Director
 *   - Year of Release
 *   - Rating
 *
 * Operations supported:
 * 1. Insert at beginning, end, and specific position
 * 2. Delete by Movie Title
 * 3. Search by Director or Rating
 * 4. Display in forward and reverse order
 * 5. Update Rating by Movie Title
 ***************************************************************/

class MovieNode {

    // Movie details
    String title;
    String director;
    int year;
    double rating;

    // Pointers to previous and next nodes
    MovieNode prev;
    MovieNode next;

    // Constructor
    public MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.prev = null;
        this.next = null;
    }
}

/*
 * This class implements all operations on the Doubly Linked List.
 */
class MovieDoublyLinkedList {

    // Head and Tail pointers
    MovieNode head;
    MovieNode tail;

    // Insert at beginning
    public void addAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Insert at end
    public void addAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);

        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Insert at specific position (1-based index)
    public void addAtPosition(int position, String title, String director, int year, double rating) {
        if (position == 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        MovieNode newNode = new MovieNode(title, director, year, rating);
        MovieNode temp = head;

        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid Position!");
            return;
        }

        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        } else {
            tail = newNode;
        }

        temp.next = newNode;
    }

    // Delete by Movie Title
    public void deleteByTitle(String title) {
        MovieNode temp = head;

        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Movie not found.");
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

        System.out.println("Movie deleted successfully.");
    }

    // Search by Director
    public void searchByDirector(String director) {
        MovieNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No movies found for director: " + director);
        }
    }

    // Search by Rating
    public void searchByRating(double rating) {
        MovieNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.rating == rating) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No movies found with rating: " + rating);
        }
    }

    // Update Rating by Movie Title
    public void updateRating(String title, double newRating) {
        MovieNode temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated successfully.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Movie not found.");
    }

    // Display all movies in forward direction
    public void displayForward() {
        MovieNode temp = head;
        System.out.println("Movies in Forward Order:");

        while (temp != null) {
            displayMovie(temp);
            temp = temp.next;
        }
    }

    // Display all movies in reverse direction
    public void displayReverse() {
        MovieNode temp = tail;
        System.out.println("Movies in Reverse Order:");

        while (temp != null) {
            displayMovie(temp);
            temp = temp.prev;
        }
    }

    // Helper method to display one movie
    private void displayMovie(MovieNode m) {
        System.out.println("------------------------------");
        System.out.println("Title    : " + m.title);
        System.out.println("Director : " + m.director);
        System.out.println("Year     : " + m.year);
        System.out.println("Rating   : " + m.rating);
    }
}

/*
 * Main class to test the Movie Management System
 */
public class MovieManagementSystem {

    public static void main(String[] args) {

        MovieDoublyLinkedList list = new MovieDoublyLinkedList();

        // Add movies
        list.addAtBeginning("Inception", "Nolan", 2010, 9.0);
        list.addAtEnd("Interstellar", "Nolan", 2014, 8.8);
        list.addAtEnd("Avatar", "Cameron", 2009, 7.9);

        // Insert at position
        list.addAtPosition(2, "Titanic", "Cameron", 1997, 9.1);

        // Display movies
        list.displayForward();
        list.displayReverse();

        // Search
        list.searchByDirector("Nolan");
        list.searchByRating(9.1);

        // Update rating
        list.updateRating("Avatar", 8.5);

        // Delete movie
        list.deleteByTitle("Titanic");

        // Display after deletion
        list.displayForward();
    }
}

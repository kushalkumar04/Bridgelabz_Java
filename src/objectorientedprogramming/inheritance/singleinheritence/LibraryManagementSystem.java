package objectorientedprogramming.inheritance.singleinheritence;
/*
 * Library Management System
 *
 * This program demonstrates single inheritance.
 * Book is the superclass that contains common book information.
 * Author is the subclass that extends Book by adding author-specific details.
 */

class Book {

    // Attributes common to all books
    String title;
    int publicationYear;

    // Constructor to initialize book details
    Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    // Method to display book information
    void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

/*
 * Author class extends Book
 *
 * Adds author-specific information such as name and biography.
 * Inherits properties and behavior from the Book class.
 */
class Author extends Book {

    // Additional attributes specific to Author
    String name;
    String bio;

    // Constructor using super keyword
    Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    // Overridden method to include author details
    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Author Name: " + name);
        System.out.println("Author Bio: " + bio);
    }
}

public class LibraryManagementSystem {

    public static void main(String[] args) {

        // Creating Author object which also represents a Book
        Author book1 = new Author(
                "Effective Java",
                2018,
                "Joshua Bloch",
                "Expert in Java and API design"
        );

        book1.displayInfo();
    }
}
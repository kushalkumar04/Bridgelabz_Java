package objectorientedprogramming.instaceofoperators;
/*
 * Book class demonstrates static, this, final, and instanceof
 */

public class Book {

    // Static variable
    static String libraryName = "Central Library";

    // Final variable
    final String isbn;

    // Instance variables
    String title;
    String author;

    // Constructor using this keyword
    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Static method
    static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    // Method using instanceof
    void displayBookDetails(Object obj) {
        if (obj instanceof Book) {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        }
    }

    public static void main(String[] args) {
        Book b1 = new Book("Java Basics", "James", "ISBN123");
        Book.displayLibraryName();
        b1.displayBookDetails(b1);
    }
}
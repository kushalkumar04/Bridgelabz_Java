package objectorientedprogramming.classandobject.level1;

/*
 * This class represents a Book with details such as
 * title, author, and price. It also provides a method
 * to display these details in a readable format.
 */
class Book {

    // Instance variables to store book information
    String title;
    String author;
    double price;

    // Method to display book details
    public void displayDetails() {
        System.out.println("Book Title : " + title);
        System.out.println("Author     : " + author);
        System.out.println("Price      : INR " + price);
    }
}

/*
 * This class contains the main method to create a Book object
 * and call the display method.
 */
public class BookDetails {

    public static void main(String[] args) {

        // Create an object of Book class
        Book book = new Book();

        // Assign values to the book attributes
        book.title = "Clean Code";
        book.author = "Robert C. Martin";
        book.price = 550.0;

        // Display the book details
        book.displayDetails();
    }
}

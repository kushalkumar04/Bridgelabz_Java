package objectorientedprogramming.encapsulation;
/*
 * Library Management System
 *
 * Features:
 * - Abstract LibraryItem class
 * - Interface Reservable
 * - Subclasses Book, Magazine, DVD
 * - Encapsulation
 * - Polymorphism demonstrated via LibraryItem references
 */

import java.util.ArrayList;
import java.util.List;

interface Reservable {
    void reserveItem(String borrower);
    boolean checkAvailability();
}

abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public String getItemId() { return itemId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }

    public abstract int getLoanDuration(); // days
}

class Book extends LibraryItem implements Reservable {
    private boolean isAvailable = true;

    public Book(String id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14;
    }

    @Override
    public void reserveItem(String borrower) {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book reserved for: " + borrower);
        } else {
            System.out.println("Book not available");
        }
    }

    @Override
    public boolean checkAvailability() { return isAvailable; }
}

class Magazine extends LibraryItem {
    public Magazine(String id, String title, String author) { super(id, title, author); }

    @Override
    public int getLoanDuration() { return 7; }
}

class DVD extends LibraryItem {
    public DVD(String id, String title, String author) { super(id, title, author); }

    @Override
    public int getLoanDuration() { return 3; }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();
        Book book = new Book("B001", "Java Basics", "Alice");
        Magazine mag = new Magazine("M001", "Tech Monthly", "Bob");
        DVD dvd = new DVD("D001", "Inception", "Christopher Nolan");

        items.add(book);
        items.add(mag);
        items.add(dvd);

        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            if (item instanceof Reservable) ((Reservable) item).reserveItem("Charlie");
            System.out.println("---------------------------------");
        }
    }
}
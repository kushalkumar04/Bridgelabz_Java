package javafeatures;

/*
 * This program performs book recommendation processing
 * using Java 8 Stream API. It filters, transforms, sorts,
 * and paginates book results.
 */
import java.util.*;
import java.util.stream.*;

class Book {
    String title;
    String author;
    String genre;
    double rating;

    public Book(String title, String author, String genre, double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }
}

class BookRecommendation {
    String title;
    double rating;

    public BookRecommendation(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    public String toString() {
        return title + " | Rating: " + rating;
    }
}

public class BookRecommendationSystem {

    public static void main(String[] args) {

        List<Book> books = Arrays.asList(
                new Book("Dune", "Frank Herbert", "Science Fiction", 4.8),
                new Book("Neuromancer", "William Gibson", "Science Fiction", 4.2),
                new Book("Foundation", "Isaac Asimov", "Science Fiction", 4.6),
                new Book("1984", "George Orwell", "Dystopian", 4.7),
                new Book("Snow Crash", "Neal Stephenson", "Science Fiction", 4.1),
                new Book("The Martian", "Andy Weir", "Science Fiction", 4.5),
                new Book("Hyperion", "Dan Simmons", "Science Fiction", 4.4),
                new Book("Brave New World", "Aldous Huxley", "Dystopian", 4.3),
                new Book("Ender's Game", "Orson Scott Card", "Science Fiction", 4.3),
                new Book("Ready Player One", "Ernest Cline", "Science Fiction", 4.0),
                new Book("I, Robot", "Isaac Asimov", "Science Fiction", 4.7),
                new Book("Starship Troopers", "Robert Heinlein", "Science Fiction", 4.1)
        );

        // 1, 2, 3: Filter, transform, sort
        List<BookRecommendation> recommendations =
                books.stream()
                        .filter(b -> b.genre.equals("Science Fiction") && b.rating > 4.0)
                        .map(b -> new BookRecommendation(b.title, b.rating))
                        .sorted((b1, b2) -> Double.compare(b2.rating, b1.rating))
                        .collect(Collectors.toList());

        System.out.println("All Recommendations:");
        recommendations.forEach(System.out::println);

        // 4. Pagination: top 10 books, page size = 5
        int pageSize = 5;
        List<BookRecommendation> top10 =
                recommendations.stream()
                        .limit(10)
                        .collect(Collectors.toList());

        System.out.println("\nPage 1:");
        top10.stream()
                .limit(pageSize)
                .forEach(System.out::println);

        System.out.println("\nPage 2:");
        top10.stream()
                .skip(pageSize)
                .limit(pageSize)
                .forEach(System.out::println);
    }
}

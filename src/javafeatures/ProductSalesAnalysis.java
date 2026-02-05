package javafeatures;

/*
 * This program performs product sales analysis using Java 8 Streams.
 * It filters sales, transforms them into total revenue objects,
 * sorts by revenue, and retrieves the top N products.
 */
import java.util.*;
import java.util.stream.*;

class Sale {
    int productId;
    int quantity;
    double price;

    public Sale(int productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }
}

class ProductSales {
    int productId;
    double totalRevenue;

    public ProductSales(int productId, double totalRevenue) {
        this.productId = productId;
        this.totalRevenue = totalRevenue;
    }

    public String toString() {
        return "Product " + productId + " | Revenue: $" + totalRevenue;
    }
}

public class ProductSalesAnalysis {

    public static void main(String[] args) {

        List<Sale> sales = Arrays.asList(
                new Sale(101, 5, 100),
                new Sale(102, 15, 80),
                new Sale(103, 20, 50),
                new Sale(104, 8, 200),
                new Sale(105, 25, 40),
                new Sale(106, 12, 120),
                new Sale(107, 30, 60)
        );

        // 1. Filter sales where quantity > 10
        List<ProductSales> productSales = sales.stream()
                .filter(s -> s.quantity > 10)
                // 2. Transform into ProductSales
                .map(s -> new ProductSales(s.productId, s.quantity * s.price))
                // 3. Sort by revenue descending
                .sorted((p1, p2) -> Double.compare(p2.totalRevenue, p1.totalRevenue))
                .collect(Collectors.toList());

        System.out.println("Filtered and Sorted Product Sales:");
        productSales.forEach(System.out::println);

        // 4. Top 5 products by revenue
        System.out.println("\nTop 5 Products by Revenue:");
        productSales.stream()
                .limit(5)
                .forEach(System.out::println);
    }
}

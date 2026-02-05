package javafeatures;

/*
 * This program demonstrates various Stream and Lambda operations
 * on a list of insurance policies and text data.
 * It includes filtering, sorting, grouping, aggregation,
 * and text frequency analysis.
 */

import java.util.*;
import java.util.stream.*;

class Policy {
    String policyNumber;
    String holderName;
    double premiumAmount;

    public Policy(String policyNumber, String holderName, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.premiumAmount = premiumAmount;
    }

    public String toString() {
        return policyNumber + " | " + holderName + " | $" + premiumAmount;
    }
}

public class InsuranceStreamExample {

    public static void main(String[] args) {

        List<Policy> policies = Arrays.asList(
                new Policy("P101", "Alice Smith", 1500),
                new Policy("P102", "Bob Johnson", 900),
                new Policy("P103", "Carol Smith", 2200),
                new Policy("P104", "David Brown", 1800),
                new Policy("P105", "Eve Davis", 1100)
        );

        // 1. Filter policies > 1200
        System.out.println("1. Premium > 1200:");
        policies.stream()
                .filter(p -> p.premiumAmount > 1200)
                .forEach(System.out::println);

        // 2. Sort by holder name
        System.out.println("\n2. Sorted by Holder Name:");
        policies.stream()
                .sorted((p1, p2) -> p1.holderName.compareTo(p2.holderName))
                .forEach(System.out::println);

        // 3. Total premium
        double totalPremium = policies.stream()
                .map(p -> p.premiumAmount)
                .reduce(0.0, Double::sum);
        System.out.println("\n3. Total Premium: $" + totalPremium);

        // 4. Print details
        System.out.println("\n4. Policy Details:");
        policies.forEach(p ->
                System.out.println("Policy: " + p.policyNumber +
                        ", Holder: " + p.holderName +
                        ", Premium: $" + p.premiumAmount));

        // 5. Premium between 1000 and 2000
        System.out.println("\n5. Premium between 1000 and 2000:");
        policies.stream()
                .filter(p -> p.premiumAmount >= 1000 && p.premiumAmount <= 2000)
                .forEach(System.out::println);

        // 6. Policy with highest premium
        Policy highest = policies.stream()
                .max(Comparator.comparingDouble(p -> p.premiumAmount))
                .orElse(null);
        System.out.println("\n6. Highest Premium Policy: " + highest);

        // 7. Group by holder name initial
        System.out.println("\n7. Group by Holder Initial:");
        Map<Character, List<Policy>> grouped =
                policies.stream()
                        .collect(Collectors.groupingBy(
                                p -> p.holderName.charAt(0)
                        ));
        grouped.forEach((k, v) -> System.out.println(k + ": " + v));

        // 8. Average premium
        double avgPremium = policies.stream()
                .mapToDouble(p -> p.premiumAmount)
                .average()
                .orElse(0);
        System.out.println("\n8. Average Premium: $" + avgPremium);

        // 9. Sort by premium
        System.out.println("\n9. Sorted by Premium:");
        policies.stream()
                .sorted(Comparator.comparingDouble(p -> p.premiumAmount))
                .forEach(System.out::println);

        // 10. Any premium > 2000
        boolean anyHigh = policies.stream()
                .anyMatch(p -> p.premiumAmount > 2000);
        System.out.println("\n10. Any premium > 2000: " + anyHigh);

        // 11. Count policies by premium range
        long low = policies.stream().filter(p -> p.premiumAmount <= 1000).count();
        long mid = policies.stream()
                .filter(p -> p.premiumAmount > 1000 && p.premiumAmount <= 2000)
                .count();
        long high = policies.stream().filter(p -> p.premiumAmount > 2000).count();

        System.out.println("\n11. Premium Ranges:");
        System.out.println("0–1000: " + low);
        System.out.println("1001–2000: " + mid);
        System.out.println(">2000: " + high);

        // 12. Unique holder names
        System.out.println("\n12. Unique Holder Names:");
        policies.stream()
                .map(p -> p.holderName)
                .distinct()
                .forEach(System.out::println);

        // 13. Holder name contains "Smith"
        System.out.println("\n13. Holder contains 'Smith':");
        policies.stream()
                .filter(p -> p.holderName.contains("Smith"))
                .forEach(System.out::println);

        // 14. Map policy number → premium
        System.out.println("\n14. Policy Map:");
        Map<String, Double> policyMap =
                policies.stream()
                        .collect(Collectors.toMap(
                                p -> p.policyNumber,
                                p -> p.premiumAmount
                        ));
        System.out.println(policyMap);

        // 15. Most frequent words
        System.out.println("\n15. Top 3 frequent words:");
        String text = "Java is great. Java streams are powerful. Streams make Java functional.";

        Map<String, Long> wordFreq =
                Arrays.stream(text.toLowerCase().replaceAll("[^a-z ]", "").split("\\s+"))
                        .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        wordFreq.entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .limit(3)
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        // 16. Second most repeated word
        System.out.println("\n16. Second most frequent word:");
        wordFreq.entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .skip(1)
                .findFirst()
                .ifPresent(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}


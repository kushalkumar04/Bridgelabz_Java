package javafeatures;

/*
 * This program performs fraud detection using Java 8 Streams.
 * It filters fraudulent transactions, groups them by policy,
 * calculates totals, and generates alerts for risky policies.
 */
import java.util.*;
import java.util.stream.*;
import java.time.*;

class Transaction {
    String transactionId;
    String policyNumber;
    double amount;
    LocalDate transactionDate;
    boolean isFraudulent;

    public Transaction(String transactionId, String policyNumber,
                       double amount, LocalDate transactionDate,
                       boolean isFraudulent) {
        this.transactionId = transactionId;
        this.policyNumber = policyNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.isFraudulent = isFraudulent;
    }
}

class FraudSummary {
    long fraudCount;
    double totalFraudAmount;

    public FraudSummary(long fraudCount, double totalFraudAmount) {
        this.fraudCount = fraudCount;
        this.totalFraudAmount = totalFraudAmount;
    }

    public String toString() {
        return "Fraud Count: " + fraudCount +
                ", Total Amount: $" + totalFraudAmount;
    }
}

public class FraudDetection {

    public static void main(String[] args) {

        List<Transaction> transactions = Arrays.asList(
                new Transaction("T1", "P101", 15000, LocalDate.now(), true),
                new Transaction("T2", "P101", 20000, LocalDate.now(), true),
                new Transaction("T3", "P101", 12000, LocalDate.now(), true),
                new Transaction("T4", "P101", 8000, LocalDate.now(), true),
                new Transaction("T5", "P102", 30000, LocalDate.now(), true),
                new Transaction("T6", "P102", 25000, LocalDate.now(), true),
                new Transaction("T7", "P102", 18000, LocalDate.now(), true),
                new Transaction("T8", "P103", 9000, LocalDate.now(), false)
        );

        // 1. Filter fraudulent transactions > 10000
        List<Transaction> filtered = transactions.stream()
                .filter(t -> t.isFraudulent && t.amount > 10000)
                .collect(Collectors.toList());

        // 2 & 3. Group by policy and aggregate fraud count and total
        Map<String, FraudSummary> fraudStats =
                filtered.stream()
                        .collect(Collectors.groupingBy(
                                t -> t.policyNumber,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        list -> new FraudSummary(
                                                list.size(),
                                                list.stream()
                                                        .mapToDouble(t -> t.amount)
                                                        .sum()
                                        )
                                )
                        ));

        System.out.println("Fraud Summary by Policy:");
        fraudStats.forEach((policy, summary) ->
                System.out.println(policy + " -> " + summary));

        // 4. Generate alerts
        System.out.println("\nFraud Alerts:");
        fraudStats.entrySet().stream()
                .filter(entry ->
                        entry.getValue().fraudCount > 5 ||
                                entry.getValue().totalFraudAmount > 50000)
                .forEach(entry ->
                        System.out.println("ALERT: Policy " +
                                entry.getKey() +
                                " -> " + entry.getValue()));
    }
}

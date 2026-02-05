package javafeatures;

/*
 * This program performs claims analysis using Java 8 Streams.
 * It filters approved claims, groups them by policy number,
 * calculates total and average claim amounts,
 * and finds the top 3 policies with highest totals.
 */
import java.util.*;
import java.util.stream.*;
import java.time.*;

class Claim {
    String claimId;
    String policyNumber;
    double claimAmount;
    LocalDate claimDate;
    String status;

    public Claim(String claimId, String policyNumber, double claimAmount,
                 LocalDate claimDate, String status) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.status = status;
    }
}

public class ClaimsAnalysis {

    public static void main(String[] args) {

        List<Claim> claims = Arrays.asList(
                new Claim("C1", "P101", 6000, LocalDate.of(2024, 1, 10), "Approved"),
                new Claim("C2", "P101", 8000, LocalDate.of(2024, 2, 15), "Approved"),
                new Claim("C3", "P102", 3000, LocalDate.of(2024, 3, 20), "Rejected"),
                new Claim("C4", "P103", 9000, LocalDate.of(2024, 4, 5), "Approved"),
                new Claim("C5", "P103", 7000, LocalDate.of(2024, 5, 12), "Approved"),
                new Claim("C6", "P104", 12000, LocalDate.of(2024, 6, 18), "Approved")
        );

        // 1. Filter approved claims with amount > 5000
        List<Claim> filteredClaims = claims.stream()
                .filter(c -> c.status.equals("Approved") && c.claimAmount > 5000)
                .collect(Collectors.toList());

        // 2. Group by policy number
        Map<String, List<Claim>> groupedClaims =
                filteredClaims.stream()
                        .collect(Collectors.groupingBy(c -> c.policyNumber));

        // 3. Aggregate: total and average claim amount per policy
        Map<String, DoubleSummaryStatistics> statsByPolicy =
                filteredClaims.stream()
                        .collect(Collectors.groupingBy(
                                c -> c.policyNumber,
                                Collectors.summarizingDouble(c -> c.claimAmount)
                        ));

        System.out.println("Total and Average Claim per Policy:");
        statsByPolicy.forEach((policy, stats) -> {
            System.out.println("Policy: " + policy +
                    ", Total: $" + stats.getSum() +
                    ", Average: $" + stats.getAverage());
        });

        // 4. Top 3 policies by total claim amount
        System.out.println("\nTop 3 Policies by Total Claim Amount:");
        statsByPolicy.entrySet().stream()
                .sorted((e1, e2) ->
                        Double.compare(e2.getValue().getSum(),
                                e1.getValue().getSum()))
                .limit(3)
                .forEach(e ->
                        System.out.println("Policy: " + e.getKey() +
                                ", Total: $" + e.getValue().getSum()));
    }
}

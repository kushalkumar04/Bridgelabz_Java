package javafeatures;

/*
 * This program performs risk assessment for policy holders
 * using Java 8 Streams. It filters, transforms, sorts,
 * and categorizes policy holders based on risk score.
 */
import java.util.*;
import java.util.stream.*;

class PolicyHolder {
    int holderId;
    String name;
    int age;
    String policyType;
    double premiumAmount;

    public PolicyHolder(int holderId, String name, int age,
                        String policyType, double premiumAmount) {
        this.holderId = holderId;
        this.name = name;
        this.age = age;
        this.policyType = policyType;
        this.premiumAmount = premiumAmount;
    }
}

class RiskAssessment {
    int holderId;
    String name;
    double riskScore;

    public RiskAssessment(int holderId, String name, double riskScore) {
        this.holderId = holderId;
        this.name = name;
        this.riskScore = riskScore;
    }

    public String toString() {
        return holderId + " | " + name + " | Risk Score: " + riskScore;
    }
}

public class PolicyHolderRiskAssessment {

    public static void main(String[] args) {

        List<PolicyHolder> holders = Arrays.asList(
                new PolicyHolder(1, "Alice", 65, "Life", 400),
                new PolicyHolder(2, "Bob", 55, "Life", 500),
                new PolicyHolder(3, "Carol", 70, "Life", 600),
                new PolicyHolder(4, "David", 68, "Health", 700),
                new PolicyHolder(5, "Eve", 75, "Life", 300)
        );

        // 1. Filter: Life policy holders with age > 60
        List<RiskAssessment> assessments =
                holders.stream()
                        .filter(h -> h.policyType.equals("Life") && h.age > 60)
                        // 2. Transform: create risk assessment
                        .map(h -> new RiskAssessment(
                                h.holderId,
                                h.name,
                                h.premiumAmount / h.age))
                        // 3. Sort by risk score descending
                        .sorted((r1, r2) ->
                                Double.compare(r2.riskScore, r1.riskScore))
                        .collect(Collectors.toList());

        System.out.println("Sorted Risk Assessments:");
        assessments.forEach(System.out::println);

        // 4. Categorize into risk groups
        Map<String, List<RiskAssessment>> categorized =
                assessments.stream()
                        .collect(Collectors.groupingBy(r ->
                                r.riskScore > 0.5 ? "High Risk" : "Low Risk"));

        System.out.println("\nRisk Categories:");
        categorized.forEach((category, list) -> {
            System.out.println(category + ":");
            list.forEach(System.out::println);
        });
    }
}


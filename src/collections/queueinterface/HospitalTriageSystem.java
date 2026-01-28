package collections.queueinterface;

/*
 * This program simulates a Hospital Triage System using PriorityQueue.
 * Patients with higher severity are treated first.
 * The queue orders patients based on severity in descending order.
 */
import java.util.*;

class Patient {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
}

public class HospitalTriageSystem {

    public static void main(String[] args) {

        // PriorityQueue with custom comparator (higher severity first)
        PriorityQueue<Patient> queue = new PriorityQueue<>(
                (p1, p2) -> p2.severity - p1.severity
        );

        queue.add(new Patient("John", 3));
        queue.add(new Patient("Alice", 5));
        queue.add(new Patient("Bob", 2));

        System.out.println("Treatment Order:");

        while (!queue.isEmpty()) {
            Patient p = queue.poll();
            System.out.println(p.name + " (Severity: " + p.severity + ")");
        }
    }
}


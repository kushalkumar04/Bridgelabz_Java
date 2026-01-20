package stacksandqueues;

import java.util.*;

class CircularTour {

    static class PetrolPump {
        int petrol;
        int distance;

        PetrolPump(int p, int d) {
            petrol = p;
            distance = d;
        }
    }

    public static int findStartingPoint(PetrolPump[] pumps) {
        Queue<Integer> queue = new LinkedList<>();
        int surplus = 0;
        int i = 0;
        int n = pumps.length;

        while (queue.size() < n) {
            surplus += pumps[i].petrol - pumps[i].distance;
            queue.add(i);

            // If surplus becomes negative, remove from front
            while (surplus < 0 && !queue.isEmpty()) {
                int removed = queue.poll();
                surplus -= (pumps[removed].petrol - pumps[removed].distance);
            }

            i = (i + 1) % n;
        }

        return queue.peek(); // starting index
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
                new PetrolPump(6, 4),
                new PetrolPump(3, 6),
                new PetrolPump(7, 3)
        };

        int start = findStartingPoint(pumps);
        System.out.println("Start at Petrol Pump Index: " + start);
    }
}

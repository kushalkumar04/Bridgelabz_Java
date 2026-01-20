package hashmapsandhashfunctions;
import java.util.HashSet;

class PairWithGivenSum {

    public static boolean hasPairWithSum(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;

            if (set.contains(complement)) {
                System.out.println("Pair Found: " + num + " and " + complement);
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {8, 7, 2, 5, 3, 1};
        int target = 10;

        if (!hasPairWithSum(arr, target)) {
            System.out.println("No such pair exists");
        }
    }
}

package hashmapsandhashfunctions;

import java.util.HashSet;

class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int longest = 0;

        // Store all elements
        for (int num : nums) {
            set.add(num);
        }

        // Check each number
        for (int num : set) {
            // Start only if num is the first element of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int count = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};

        int result = longestConsecutive(arr);
        System.out.println("Length of Longest Consecutive Sequence: " + result);
    }
}

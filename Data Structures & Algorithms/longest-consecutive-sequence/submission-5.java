class Solution {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        List<Integer> starts = new ArrayList<>();
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                starts.add(num);
            }
        }

        int longest = 0;
        for (int start : starts) {
            int sequenceLength = getSequenceLength(set, start);
            if (sequenceLength > longest) {
                longest = sequenceLength;
            }
        }

        return longest;
    }

    private static int getSequenceLength(Set<Integer> set, int start) {
        int result = 0;
        int curr = start;
        while (set.contains(curr)) {
            result += 1;
            curr += 1;
        }
        return result;
    }
}

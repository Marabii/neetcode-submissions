class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }

        List<Integer> starts = new ArrayList<>();

        for (int num : nums) {
            if (!numsSet.contains(num - 1)) {
                starts.add(num);
            }
        }

        int longest = 0;

        for (int start : starts) {
            int length = countLength(start, numsSet);
            if (length > longest)
                longest = length;
        }

        return longest;
    }

    private int countLength(int num, Set<Integer> numsSet) {
        int length = 0;
        while (numsSet.contains(num)) {
            length++;
            num++;
        }

        return length;
    }
}

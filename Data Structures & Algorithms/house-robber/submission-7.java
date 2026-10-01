class Solution {
    public int rob(int[] nums) {
        int[] cache = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            cache[i] = -1;
        }

        return robHelper(nums, cache, 0);
    }

    private int robHelper(int[] nums, int[] cache, int i) {
        if (i >= nums.length) {
            return 0;
        }

        if (cache[i] != -1) {
            return cache[i];
        }

        // Rob i then move to i + 2
        int choice1 = nums[i] + robHelper(nums, cache, i + 2);

        // Skip i
        int choice2 = robHelper(nums, cache, i + 1);

        int amount = Math.max(choice1, choice2);
        cache[i] = amount;
        return amount;
    }
}

class Solution {
    public int rob(int[] nums) {
        int p1 = 0;
        int p2 = 0;

        for (int i = 0; i < nums.length; i++) {
            int curr = Math.max(nums[i] + p1, p2);
            p1 = p2;
            p2 = curr;
        }

        return p2;
    }
}

class Solution {
    public static int findMin(int[] nums) {
        if (nums[0] < nums[nums.length - 1] || nums.length == 1) {
            return nums[0];
        }

        return findMinHelper(nums, 0, nums.length - 1, nums[nums.length - 1]);
    }

    public static int findMinHelper(int[] nums, int start, int end, int lastElement) {
        int l = (start + end) / 2;
        if (nums[l] > nums[l + 1])
            return nums[l + 1];
        if (nums[l] <= lastElement) {
            return findMinHelper(nums, start, l, lastElement);
        } else {
            return findMinHelper(nums, l, end, lastElement);
        }
    }
}

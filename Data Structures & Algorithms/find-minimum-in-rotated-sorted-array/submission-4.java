class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int currMin = Integer.MAX_VALUE;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] >= nums[left]) {
                // This means nums[left..middle + 1] is sorted.
                if (nums[left] < currMin) {
                    currMin = nums[left];
                }

                left = middle + 1;
            } else if (nums[middle] <= nums[right]) {
                // This means nums[middle..right + 1] is sorted
                if (nums[middle] < currMin) {
                    currMin = nums[middle];
                }

                right = middle - 1;
            } else {
                throw new IllegalArgumentException();
            }
        }

        return currMin;
    }
}

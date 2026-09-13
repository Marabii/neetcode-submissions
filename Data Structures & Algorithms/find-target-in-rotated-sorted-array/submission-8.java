class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] >= nums[left]) {
                // This means nums[left..middle + 1] is sorted.
                if (nums[left] <= target && nums[middle] >= target) {
                    return searchIn(nums, left, middle, target);
                }

                left = middle + 1;
            } else {
                // This means nums[middle..right + 1] is sorted
                if (nums[middle] <= target && nums[right] >= target) {
                    return searchIn(nums, middle, right, target);
                }

                right = middle - 1;
            }
        }

        return -1;
    }

    private int searchIn(int[] nums, int leftBoundary, int rightBoundary, int target) {
        int left = leftBoundary;
        int right = rightBoundary;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                return middle;
            }
        }

        return -1;
    }
}

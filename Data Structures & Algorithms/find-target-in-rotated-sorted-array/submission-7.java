class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int lastElement = nums[nums.length - 1];
        int breakIndex = -1;

        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        if (nums.length == 2) {
            if (nums[0] == target) return 0;
            if (nums[1] == target) return 1;
            return -1;
        }

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] <= lastElement) {
                right = middle - 1;
            } else if (nums[middle] > lastElement) {
                left = middle + 1;
            }

            if (nums[middle] > nums[middle + 1]) {
                breakIndex = middle + 1;
                break;
            }
        }

        System.out.println(breakIndex);

        if (breakIndex == -1) {
            left = 0;
            right = nums.length - 1;
        } else {
            if (target >= nums[breakIndex] && target <= lastElement) {
                left = breakIndex;
                right = nums.length - 1;
            } else {
                left = 0;
                right = breakIndex - 1;
            }
        }

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target)
                return middle;
            if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }
}

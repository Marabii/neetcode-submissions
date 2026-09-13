class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] productsLessThan = new int[nums.length];
        int[] productsLargerThan = new int[nums.length];

        productsLessThan[0] = 1;
        productsLargerThan[nums.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            productsLessThan[i] = productsLessThan[i - 1] * nums[i - 1];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            productsLargerThan[i] = productsLargerThan[i + 1] * nums[i + 1];
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = productsLargerThan[i] * productsLessThan[i];
        }

        return result;
    }
}  

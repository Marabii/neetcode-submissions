class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixes = new int[nums.length];
        int[] suffixes = new int[nums.length];

        prefixes[0] = 1;
        suffixes[nums.length - 1] = 1;

        int curr = 1;
        for (int i = 0; i < nums.length; i++) {
            curr *= nums[i];
            prefixes[i] = curr;
        }

        curr = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            curr *= nums[i];
            suffixes[i] = curr;
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = ((i - 1 >= 0) ? prefixes[i - 1] : 1) * ((i + 1 < nums.length) ? suffixes[i + 1] : 1);
        }
        return result;
    }
}  

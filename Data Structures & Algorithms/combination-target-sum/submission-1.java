class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> scratch = new ArrayList<>();
        combinationSumHelper(nums, target, scratch, result, 0);
        return result;
    }

    private void combinationSumHelper(int[] nums, int target, List<Integer> scratch,
            List<List<Integer>> result, int i) {
        int sum = sum(scratch);

        if (sum == target) {
            result.add(new ArrayList<>(scratch));
            return;
        }

        if (sum > target || i >= nums.length) {
            return;
        }

        // reuse the same i:
        scratch.add(nums[i]);
        combinationSumHelper(nums, target, scratch, result, i);
        scratch.removeLast();

        // skip it:
        combinationSumHelper(nums, target, scratch, result, i + 1);
    }

    private int sum(List<Integer> arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        return sum;
    }
}

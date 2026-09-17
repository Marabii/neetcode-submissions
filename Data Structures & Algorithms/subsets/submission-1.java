class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of());
        List<Integer> scratch = new ArrayList<>();
        subsetsHelper(nums, result, scratch, 0);

        return result;
    }

    private void subsetsHelper(int[] nums, List<List<Integer>> result, List<Integer> scratch, int curr) {
        if (curr >= nums.length)
            return;

        // take the current position:
        scratch.add(nums[curr]);
        result.add(new ArrayList<>(scratch));
        subsetsHelper(nums, result, scratch, curr + 1);
        scratch.removeLast();

        // skip it
        subsetsHelper(nums, result, scratch, curr + 1);
    }
}

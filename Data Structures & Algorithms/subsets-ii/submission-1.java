class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> scratch = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        subsetsWithDupHelper(nums, scratch, result, 0);
        return result;
    }

    private void subsetsWithDupHelper(int[] nums, List<Integer> scratch, List<List<Integer>> result, int i) {
        if (i == nums.length) {
            result.add(new ArrayList<>(scratch));
            return;
        }

        scratch.add(nums[i]);
        subsetsWithDupHelper(nums, scratch, result, i + 1);
        scratch.removeLast();

        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        subsetsWithDupHelper(nums, scratch, result, i + 1);
    }
}

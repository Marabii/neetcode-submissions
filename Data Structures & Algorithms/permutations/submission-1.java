class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return permuteHelper(nums, 0);
    }

    private List<List<Integer>> permuteHelper(int[] nums, int start) {
        if (start == nums.length) {
            return List.of(List.of());
        }

        List<List<Integer>> next = permuteHelper(nums, start + 1);
        int curr = nums[start];

        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> arr : next) {
            for (int i = 0; i <= arr.size(); i++) {
                List<Integer> copy = new ArrayList<>(arr);
                copy.add(i, curr);
                result.add(copy);
            }
        }

        return result;
    }
}

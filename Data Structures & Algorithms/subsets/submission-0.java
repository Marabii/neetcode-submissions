class Solution {
    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int start = 0;
        backTrack(cur, nums, res, start);
        return res;
    }

    public static void backTrack(List<Integer> curr, int[] nums, List<List<Integer>> res, int i) {

        if (i == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        // skip ith element
        backTrack(curr, nums, res, i + 1);

        // add ith element
        curr.add(nums[i]);
        backTrack(curr, nums, res, i + 1);
        curr.remove(curr.size() - 1);
    }
}

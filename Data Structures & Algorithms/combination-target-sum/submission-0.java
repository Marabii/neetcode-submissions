class Solution {
    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        int i = 0;
        backTrack(nums, target, res, curr, i);
        return res;
    }

    private static void backTrack(int[] nums, int target, List<List<Integer>> res, List<Integer> curr, int i) {
        int currSum = sum(curr);

        if (currSum > target)
            return;

        if (currSum == target) {
            res.add(new ArrayList<>(curr));
            return;
        }

        // take current element.
        if (i <= nums.length - 1) {
            curr.add(nums[i]);
            backTrack(nums, target, res, curr, i);
            curr.remove(curr.size() - 1);
        }

        // skip it
        if (i + 1 <= nums.length - 1) {
            backTrack(nums, target, res, curr, i + 1);
        }
    }

    private static int sum(List<Integer> arr) {
        int res = 0;
        for (int num : arr) {
            res += num;
        }

        return res;
    }
}

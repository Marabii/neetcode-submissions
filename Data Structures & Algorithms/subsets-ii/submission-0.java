class Solution {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<List<Integer>> resSet = new HashSet<>();
        List<Integer> curr = new ArrayList<>();
        backTrack(resSet, curr, 0, nums);
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> arr : resSet) {
            res.add(arr);
        }
        return res;
    }

    private static void backTrack(HashSet<List<Integer>> res, List<Integer> curr, int start, int[] nums) {
        if (start == nums.length) {
            List<Integer> sol = new ArrayList<>(curr);
            Collections.sort(sol);
            res.add(sol);
            return;
        }

        backTrack(res, curr, start + 1, nums);

        curr.add(nums[start]);
        backTrack(res, curr, start + 1, nums);
        curr.remove(curr.size() - 1);
    }

}

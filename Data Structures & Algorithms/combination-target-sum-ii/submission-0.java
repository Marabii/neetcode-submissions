class Solution {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backTrack(candidates, target, 0, res, curr);
        return res;
    }

    private static void backTrack(int[] candidates, int target, int i, List<List<Integer>> res, List<Integer> curr) {
        int currSum = sum(curr);

        if (currSum == target) {
            List<Integer> sol = new ArrayList<>(curr);
            quickSort(sol, 0, sol.size() - 1);
            if (!res.contains(sol))
                res.add(sol);
            return;
        }

        if (currSum > target || i == candidates.length)
            return;

        // take nums[i]
        curr.add(candidates[i]);
        backTrack(candidates, target, i + 1, res, curr);
        curr.remove(curr.size() - 1);

        // skip nums[i]
        backTrack(candidates, target, i + 1, res, curr);

    }

    private static int sum(List<Integer> arr) {
        int res = 0;
        for (int num : arr) {
            res += num;
        }

        return res;
    }

    private static void quickSort(List<Integer> nums, int start, int end) {
        if (end <= start)
            return;

        int i = start - 1;
        int j = start;

        while (j < end) {
            if (nums.get(j) < nums.get(end)) {
                i++;
                int temp = nums.get(i);
                nums.set(i, nums.get(j));
                nums.set(j, temp);
            }
            j++;
        }

        i++;
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);

        quickSort(nums, start, i - 1);
        quickSort(nums, i + 1, end);

    }
}

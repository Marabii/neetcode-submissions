class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2Helper(candidates, target, 0, curr, result);
        return result;
    }

    private void combinationSum2Helper(int[] candidates, int target, int i, List<Integer> curr,
            List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        if (target < 0 || i >= candidates.length) {
            return;
        }

        // take i:
        curr.add(candidates[i]);
        combinationSum2Helper(candidates, target - candidates[i], i + 1, curr, result);
        curr.removeLast();

        // skip i
        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }
        combinationSum2Helper(candidates, target, i + 1, curr, result);
    }
}

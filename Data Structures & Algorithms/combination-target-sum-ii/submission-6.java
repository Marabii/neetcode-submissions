class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> scratch = new ArrayList<>();
                Arrays.sort(candidates);
        combinationSum2Helper(candidates, target, result, scratch, 0);
        return result;
    }

    private void combinationSum2Helper(int[] candidates, int target, List<List<Integer>> result, List<Integer> scratch,
            int i) {

        if (target == 0) {
            result.add(new ArrayList<>(scratch));
            return;
        }

        if (i >= candidates.length || target < 0) {
            return;
        }

        scratch.add(candidates[i]);
        combinationSum2Helper(candidates, target - candidates[i], result, scratch, i + 1);
        scratch.removeLast();

        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i += 1;
        }

        combinationSum2Helper(candidates, target, result, scratch, i + 1);
    }
}

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> scratch = new ArrayList<>();
        Arrays.sort(candidates);

        combinationSum2Helper(candidates, target, scratch, result, 0);
        return result;
    }

    private void combinationSum2Helper(int[] candidates, int rest, List<Integer> scratch, List<List<Integer>> result,
            int i) {
        if (rest == 0) {
            List<Integer> solCopy = new ArrayList<>(scratch);
            result.add(solCopy);
            return;
        }

        if (i >= candidates.length || rest < 0) {
            return;
        }

        // take i:
        scratch.add(candidates[i]);
        combinationSum2Helper(candidates, rest - candidates[i], scratch, result, i + 1);
        scratch.removeLast();

        // Skip i:
        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }

        combinationSum2Helper(candidates, rest, scratch, result, i + 1);
    }
}

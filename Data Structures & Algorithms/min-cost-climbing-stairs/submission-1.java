class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] cache = new int[cost.length];
        for (int i = 0; i < cost.length; i++) {
            cache[i] = -1;
        }

        return Math.min(minCostClimbingStairsHelper(cost, cache, 0), minCostClimbingStairsHelper(cost, cache, 1));
    }

    private int minCostClimbingStairsHelper(int[] cost, int[] cache, int i) {
        if (i >= cost.length)
            return 0;

        if (cache[i] != -1) {
            return cache[i];
        }

        int val = cost[i] + Math.min(minCostClimbingStairsHelper(cost, cache, i + 1),
                minCostClimbingStairsHelper(cost, cache, i + 2));
        cache[i] = val;
        return val;
    }
}

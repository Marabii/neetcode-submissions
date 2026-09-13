class Solution {
    public static int minCostClimbingStairs(int[] cost) {
        return minCostClimbingStairsHelper(cost, -1);
    }

    private static int minCostClimbingStairsHelper(int[] cost, int i) {
        if (i >= cost.length)
            return 0;
        return (i >= 0 ? cost[i]
                : 0) + Math.min(minCostClimbingStairsHelper(cost, i + 1), minCostClimbingStairsHelper(cost, i + 2));
    }
}

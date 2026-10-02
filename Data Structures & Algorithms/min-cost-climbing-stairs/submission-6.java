class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] minCosts = new int[cost.length + 1];

        for (int i = 2; i <= cost.length; i++) {
            minCosts[i] = Math.min(minCosts[i - 1] + cost[i - 1], minCosts[i - 2] + cost[i - 2]);
        }


        return minCosts[cost.length];
    }
}

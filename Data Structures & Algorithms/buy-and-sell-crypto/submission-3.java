class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;

        int left = 0;
        int right = 0;

        while (left < prices.length && right < prices.length) {
            if (prices[right] <= prices[left]) {
                left = right;
                right++;
            } else {
                profit = Math.max(profit, prices[right] - prices[left]);
                right++;
            }
        }

        return profit;
    }
}

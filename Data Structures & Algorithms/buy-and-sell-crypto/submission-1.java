class Solution {
    public int maxProfit(int[] prices) {
        int start = 0;
        int end = 1;

        int mProfit = 0;

        while (end < prices.length && start < end) {
            if (prices[end] - prices[start] < 0) {
                start++;
                if (start == end) {
                    end++;
                }
            } else {
                mProfit = Math.max(mProfit, prices[end] - prices[start]);
                end++;
            }
        }

        return mProfit;
    }
}

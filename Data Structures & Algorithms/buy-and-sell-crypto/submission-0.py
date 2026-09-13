class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        left = 0
        currProfit = 0
        right = 1 
        while right < len(prices):
            if prices[left] > prices[right]:
                left += 1
                if left >= right:
                    right +=1
            else:
                currProfit = max(currProfit, prices[right] - prices[left])
                right += 1
        
        return currProfit
                
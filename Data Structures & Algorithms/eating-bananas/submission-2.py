import math
class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        if len(piles) == 1:
            return math.ceil(piles[0] / h)
        m = max(piles)

        def calculateSpeedForK(k):
            s = 0
            for pile in piles:
                if pile <= k:
                    s += 1
                else:
                    s += math.ceil(pile / k)
            return s
        
        
        start, end = 1, m
        while True:
            k = (start + end) // 2
            if calculateSpeedForK(k) <= h and calculateSpeedForK(k - 1) > h:
                return k
            if calculateSpeedForK(k) <= h:
                end = k - 1
            else:
                start = k + 1
            

class Solution:
    def maxArea(self, heights: List[int]) -> int:
        left = 0
        right = len(heights) - 1
        bestArea = 0
        while left < right:
            bestArea = max((right - left) * min(heights[right], heights[left]), bestArea)
            if heights[left] < heights[right]:
                left += 1
            else:
                right -= 1

        return bestArea

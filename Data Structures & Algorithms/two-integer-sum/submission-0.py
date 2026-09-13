class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        differences = dict()
        for i, el in enumerate(nums):
            if target - el in differences:
                return sorted([i, differences[target - el]])
            
            else:
                differences[el] = i
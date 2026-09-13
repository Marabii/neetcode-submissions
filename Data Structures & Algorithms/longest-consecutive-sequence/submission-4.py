class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if len(nums) <= 1:
            return len(nums)

        setOfNums = set(nums)
        longest = 1
        
        #find start
        starts = []
        for el in setOfNums:
            if el - 1 not in setOfNums:
                starts += [el]

        curr = 0
        for start in starts:
            while start + curr in setOfNums:
                curr += 1
            longest = max(longest, curr)
            curr = 0
        
        return longest



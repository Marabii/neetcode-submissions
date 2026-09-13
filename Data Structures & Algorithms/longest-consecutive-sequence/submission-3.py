class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if len(nums) <= 1:
            return len(nums)

        setOfNums = set(nums)
        maps = dict()

        for el in nums:
            if el + 1 in setOfNums:
                maps[el] = el + 1
        
        if len(maps.keys()) == 0:
            return 1

        starts = []
        for k in maps.keys():
            if k - 1 not in maps:
                starts += [k]

        longest = 1
        for start in starts:
            curr = 1
            while start + curr in maps:
                curr += 1
            longest = max(longest, curr)
        
        return longest + 1




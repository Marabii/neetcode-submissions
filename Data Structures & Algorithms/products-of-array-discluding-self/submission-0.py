class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prefix = [1 for _ in range(len(nums))]
        suffix = [1 for _ in range(len(nums))]

        prefix[0] = nums[0]
        suffix[-1] = nums[-1]

        for i in range(1, len(nums)):
            prefix[i] = prefix[i - 1] * nums[i]

        for i in range(len(nums) - 1):
            suffix[len(nums) - i - 2] = suffix[len(nums) - i - 1] * nums[len(nums) - i - 2]

        result = []

        for i in range(len(nums)):
            if i == 0:
                result += [suffix[1]]
            if i == len(nums) - 1:
                result += [prefix[len(nums) - 2]]
            if i > 0 and i < len(nums) - 1:
                result += [suffix[i + 1] * prefix[i - 1]]

        return result
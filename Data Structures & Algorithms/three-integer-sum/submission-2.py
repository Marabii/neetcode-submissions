class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        solutions = []
        for i in range(len(nums)):
            left = i + 1
            right = len(nums) - 1

            while right - left > 0:
                triplet = [nums[i], nums[left], nums[right]]
                triplet_sum = sum(triplet)

                if triplet_sum > 0:
                    right -= 1
                elif triplet_sum < 0:
                    left += 1
                else:
                    if triplet not in solutions:
                        solutions.append(triplet)
                    right -= 1
                    left += 1
        
        return solutions
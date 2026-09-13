class Solution:
    def search(self, nums: List[int], target: int) -> int:
        def searchHelper(start, end):
            print(start, end)
            middle = (end + start) // 2
            print(middle)
            if end - start < 1 or nums[middle] == target:
                return middle if nums[middle] == target else -1
            if target > nums[middle]:
                return searchHelper(middle + 1, end)
            if target < nums[middle]:
                return searchHelper(start, middle - 1)
        return searchHelper(0, len(nums) - 1)
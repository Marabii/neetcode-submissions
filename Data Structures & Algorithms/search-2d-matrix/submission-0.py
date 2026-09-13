class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        def searchMatrixHelper(rowStart, rowEnd) -> bool:
            if rowEnd < rowStart:
                return False
            
            middleRow = (rowEnd + rowStart) // 2

            if matrix[middleRow][0] <= target and matrix[middleRow][len(matrix[middleRow]) - 1] >= target:
                return self.searchRow(matrix[middleRow], target)
            elif matrix[middleRow][0] > target:
                return searchMatrixHelper(rowStart, middleRow - 1)
            else:
                return searchMatrixHelper(middleRow + 1, rowEnd)
            
        return searchMatrixHelper(0, len(matrix) - 1)

    def searchRow(self, nums: List[int], target: int) -> bool:
        def searchRowHelper(start, end):
            if start > end:
                return False
            middle = (start + end) // 2
            if nums[middle] == target:
                return True
            elif nums[middle] < target:
                return searchRowHelper(middle + 1, end)
            else:
                return searchRowHelper(start, middle - 1)

        return searchRowHelper(0, len(nums) - 1)
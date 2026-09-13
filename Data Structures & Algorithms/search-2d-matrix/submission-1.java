class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int up = 0;
        int down = matrix.length - 1;
        int matrixWidth = matrix[0].length;

        while (up <= down) {
            int middleFloor = up + (down - up) / 2;
            if (matrix[middleFloor][0] <= target && matrix[middleFloor][matrixWidth - 1] >= target) {
                int left = 0;
                int right = matrixWidth - 1;

                while (left <= right) {
                    int middle = left + (right - left) / 2;

                    if (matrix[middleFloor][middle] == target) {
                        return true;
                    } else if (target < matrix[middleFloor][middle]) {
                        right = middle - 1;
                    } else if (matrix[middleFloor][middle] < target) {
                        left = middle + 1;
                    }
                }

                return false;

            } else if (matrix[middleFloor][0] > target) {
                down = middleFloor - 1;
            } else if (matrix[middleFloor][0] < target) {
                up = middleFloor + 1;
            }
        }

        return false;
    }
}

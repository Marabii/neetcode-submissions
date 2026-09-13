class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;

        int rowsLength = matrix[0].length;

        while (top <= bottom) {
            int rowMiddle = top + (bottom - top) / 2;

            if (matrix[rowMiddle][0] < target && matrix[rowMiddle][rowsLength - 1] < target) {
                top = rowMiddle + 1;
            } else if (matrix[rowMiddle][0] > target && matrix[rowMiddle][rowsLength - 1] > target) {
                bottom = rowMiddle - 1;
            } else {
                int left = 0;
                int right = rowsLength - 1;

                while (left <= right) {
                    int colMiddle = left + (right - left) / 2;

                    if (matrix[rowMiddle][colMiddle] < target) {
                        left = colMiddle + 1;
                    } else if (matrix[rowMiddle][colMiddle] > target) {
                        right = colMiddle - 1;
                    } else {
                        return true;
                    }
                }

                return false;
            }
        }

        return false;
    }
}

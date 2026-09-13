class Solution {
    public int maxArea(int[] heights) {
        int start = 0;
        int end = heights.length - 1;

        int mArea = 0;

        while (end > start) {
            int area = Math.min(heights[start], heights[end]) * (end - start);
            if (area > mArea) {
                mArea = area;
            }

            if (heights[start] > heights[end]) {
                end--;
            } else {
                start++;
            }
        }

        return mArea;
    }
}

class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            if (heights[right] >= heights[left]) {
                maxArea = Math.max(maxArea, heights[left] * (right - left));
                left++;
            } else {
                maxArea = Math.max(maxArea, heights[right] * (right - left));
                right--;
            }
        }

        return maxArea;
    }
}

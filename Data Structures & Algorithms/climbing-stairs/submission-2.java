class Solution {
    public int climbStairs(int n) {
        int x = 0;
        int y = 1;

        for (int i = 0; i < n; i++) {
            int temp = x;
            x = y;
            y += temp;
        }

        return y;
    }
}

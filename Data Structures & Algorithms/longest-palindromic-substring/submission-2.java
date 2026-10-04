class Solution {
    public String longestPalindrome(String s) {
        int[] indicies = { 0, 0 };

        for (int i = 0; i < s.length(); i++) {
            int[] res1 = expandOutwardsEven(s, i, i + 1);
            int[] res2 = expandOutwardsOdd(s, i);

            int[] max = max(res1, res2);
            indicies = max(max, indicies);
        }

        return s.substring(indicies[0], indicies[1] + 1);
    }

    private int[] expandOutwardsOdd(String s, int i) {
        int j = 0;

        while (i - j >= 0 && i + j < s.length() && s.charAt(i - j) == s.charAt(i + j)) {
            j++;
        }

        j--;

        return new int[] { i - j, i + j };
    }

    private int[] expandOutwardsEven(String s, int i, int j) {
        int k = 0;

        while (i - k >= 0 && j + k < s.length() && s.charAt(i - k) == s.charAt(j + k)) {
            k++;
        }

        k--;

        return new int[] { i - k, j + k };
    }

    private int[] max(int[] res1, int[] res2) {
        if (res1[1] - res1[0] > res2[1] - res2[0]) {
            return res1;
        }

        return res2;
    }
}

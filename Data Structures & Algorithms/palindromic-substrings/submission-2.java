class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int i = 0;

        while (i < s.length()) {
            int res1 = expandOutwardsOdd(s, i);
            count += res1;

            if (i < s.length() && i - 1 >= 0 && s.charAt(i) == s.charAt(i - 1)) {
                int res2 = expandOutwardsEven(s, i, i - 1);
                count += res2;
            }

            i++;
        }

        return count;
    }

    private int expandOutwardsOdd(String s, int i) {
        int j = 0;

        while (i - j >= 0 && i + j < s.length() && s.charAt(i - j) == s.charAt(i + j)) {
            j++;
        }

        return j;
    }

    private int expandOutwardsEven(String s, int i, int j) {
        int k = 0;

        while (i - k >= 0 && j + k < s.length() && s.charAt(i - k) == s.charAt(j + k)) {
            k++;
        }

        k--;

        return k;
    }
}

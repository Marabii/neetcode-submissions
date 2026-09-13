class Solution {
    public static String longestPalindrome(String s) {
        int[] result = { 0, 0 };
        for (int i = 0; i < s.length(); i++) {
            int[] candidateOdd = expandFromIOdd(s, i);
            int[] candidateEven = expandFromIEven(s, i);
            result = maxInterval(candidateOdd, candidateEven, result);
        }

        return s.substring(result[0], result[1] + 1);
    }

    private static int[] expandFromIOdd(String s, int i) {
        int j = i;
        int k = i;

        while (j > 0 && k < s.length() - 1 && s.charAt(j - 1) == s.charAt(k + 1)) {
            j--;
            k++;
        }

        return new int[] { j, k };

    }

    private static int[] expandFromIEven(String s, int i) {
        int j = i;
        int k = i + 1;

        if (k >= s.length() || s.charAt(j) != s.charAt(k))
            return new int[] { i, i };

        while (j > 0 && k < s.length() - 1 && s.charAt(j - 1) == s.charAt(k + 1)) {
            j--;
            k++;
        }

        return new int[] { j, k };
    }

    private static int[] maxInterval(int[] candidate1, int[] candidate2, int[] result) {
        int[] candidate = ((candidate1[1] - candidate1[0]) > (candidate2[1] - candidate2[0])) ? candidate1 : candidate2;
        return ((candidate[1] - candidate[0]) > (result[1] - result[0])) ? candidate : result;
    }
}

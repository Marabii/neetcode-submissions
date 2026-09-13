class Solution {
    public static int countSubstrings(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += expandFromIEven(s, i) + expandFromIOdd(s, i);
        }

        return result;
    }

    private static int expandFromIOdd(String s, int i) {
        int j = i;
        int k = i;
        int result = 1;

        while (j > 0 && k < s.length() - 1 && s.charAt(j - 1) == s.charAt(k + 1)) {
            j--;
            k++;
            result++;
        }

        return result;

    }

    private static int expandFromIEven(String s, int i) {
        int j = i;
        int k = i + 1;

        if (k >= s.length() || s.charAt(j) != s.charAt(k))
            return 0;

        int result = 1;
        while (j > 0 && k < s.length() - 1 && s.charAt(j - 1) == s.charAt(k + 1)) {
            j--;
            k++;
            result++;
        }

        return result;
    }
}

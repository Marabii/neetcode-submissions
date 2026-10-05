class Solution {
    public int numDecodings(String s) {
        int[] cache = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            cache[i] = -1;
        }

        return numDecodingsHelper(s, 0, cache);
    }

    private int numDecodingsHelper(String s, int i, int[] cache) {
        if (i >= s.length()) {
            return 1;
        }

        if (cache[i] != -1) {
            return cache[i];
        }

        int iBranch = 0;

        // take [i:i+1]
        if (s.charAt(i) != '0') {
            iBranch = numDecodingsHelper(s, i + 1, cache);
        }

        int iP1Branch = 0;

        // take [i:i+2]
        if (i + 1 < s.length() && s.charAt(i) != '0' && Integer.parseInt(s.substring(i, i + 2)) <= 26) {
            iP1Branch = numDecodingsHelper(s, i + 2, cache);
        }

        cache[i] = iBranch + iP1Branch;

        return iBranch + iP1Branch;
    }
}

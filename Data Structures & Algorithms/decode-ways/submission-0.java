class Solution {
    public static int numDecodings(String s) {
        Map<String, Character> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            char c = (char) ((int) 'A' + i);
            map.put(Integer.toString(i + 1), c);
        }

        return numDecodingsHelper(s, 0, map);
    }

    private static int numDecodingsHelper(String s, int i, Map<String, Character> map) {
        if (i >= s.length())
            return 1;

        int takeOne = s.charAt(i) == '0' ? 0 : numDecodingsHelper(s, i + 1, map);
        int takeTwo = 0;
        if (i + 1 < s.length()) {
            takeTwo = !map.containsKey(s.substring(i, i + 2)) ? 0 : numDecodingsHelper(s, i + 2, map);
        }

        return takeOne + takeTwo;
    }

}

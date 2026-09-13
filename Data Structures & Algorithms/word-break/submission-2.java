class Solution {
    public static boolean wordBreak(String s, List<String> wordDict) {
        Map<Integer, Boolean> map = new HashMap<>();
        return wordBreakHelper(s, wordDict, 0, map);
    }

    private static boolean wordBreakHelper(String s, List<String> wordDict, int i, Map<Integer, Boolean> map) {
        if (map.containsKey(i))
            return map.get(i);
        if (i >= s.length())
            return true;

        boolean result = false;
        for (String candidate : wordDict) {
            if (candidate.length() + i - 1 < s.length() && s.substring(i, i + candidate.length()).equals(candidate)) {
                result = result || wordBreakHelper(s, wordDict, i + candidate.length(), map);
            }
        }
        map.put(i, result);
        return result;
    }
}

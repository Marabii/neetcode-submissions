class Solution {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int i = 0;
        HashSet<Character> seen = new HashSet<>();
        int length = 1;
        seen.add(s.charAt(0));
        for (int j = 0; j < s.length(); j++) {
            while (seen.contains(s.charAt(j)) && i < j) {
                seen.remove(s.charAt(i));
                i++;
            }
            seen.add(s.charAt(j));
            length = Math.max(length, j - i + 1);
        }

        return length;

    }
}

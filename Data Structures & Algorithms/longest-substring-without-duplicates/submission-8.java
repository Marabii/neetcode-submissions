class Solution {

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1)
            return s.length();

        int longest = 1;

        // Sliding window:
        int right = 0;
        int left = 0;
        Set<Character> seen = new HashSet<>();

        while (right < s.length()) {
            while (right < s.length() && !seen.contains(s.charAt(right))) {
                seen.add(s.charAt(right));
                right += 1;
            }

            longest = Math.max(longest, seen.size());

            while (right < s.length() && seen.contains(s.charAt(right))) {
                seen.remove(s.charAt(left));
                left += 1;
            }

        }

        return longest;
    }
}

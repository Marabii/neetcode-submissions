class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int longest = 0;
        Set<Character> seen = new HashSet<>();

        while (right < s.length()) {
            if (!seen.contains(s.charAt(right))) {
                seen.add(s.charAt(right));
                right++;
            }

            longest = Math.max(longest, seen.size());

            while (right < s.length() && seen.contains(s.charAt(right))) {
                seen.remove(s.charAt(left));
                left++;
            }
        }

        return longest;
    }
}

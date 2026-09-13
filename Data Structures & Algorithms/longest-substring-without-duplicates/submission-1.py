class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) <= 1:
            return len(s)
        left = 0
        right = 1
        seen = set(s[0])
        longest = 1
        while right < len(s):
            if s[right] in seen:
                while s[right] in seen:
                    seen.remove(s[left])
                    left += 1
            else:
                seen.add(s[right])
                longest = max(longest, right - left + 1)
                right += 1

        return longest


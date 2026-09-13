class Solution:
    def isPalindrome(self, s: str) -> bool:
        cleanedString = ""

        for char in s:
            char = char.lower()
            if (ord(char) - ord("a") >= 0 and ord(char) - ord("a") <= 26) or char.isdigit():
                cleanedString += char

        left = 0
        right = len(cleanedString) - 1

        while right - left >= 0:
            if cleanedString[left] != cleanedString[right]:
                return False
            right -= 1
            left += 1
        
        return True
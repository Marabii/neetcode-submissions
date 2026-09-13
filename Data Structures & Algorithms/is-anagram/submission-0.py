class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        
        alphabet = "abcdefghijklmnopqrstuvwxyz"
        frequency = dict()
        for char in alphabet:
            frequency[char] = 0
        
        for char in s:
            frequency[char] = frequency[char] + 1
        
        for char in t:
            frequency[char] = frequency[char] - 1
        
        for char in frequency:
            if frequency[char] != 0:
                return False
        
        return True

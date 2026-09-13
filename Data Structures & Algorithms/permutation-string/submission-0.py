class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        sp = dict()
        for char in s1:
            sp[char] = sp.get(char, 0) + 1
        
        spCopy = dict(sp)
        total = len(s1)

        left = 0
        while left <= len(s2) - len(s1):
            right = left + len(s1) - 1
            i = left
            while i <= right:
                if s2[i] in spCopy:
                    if spCopy[s2[i]] > 0:
                        spCopy[s2[i]] -= 1
                        total -= 1
                    if total == 0:
                        return True
                else:
                    break
                i += 1

            spCopy = dict(sp)
            total = len(s1)
            left += 1

        return False
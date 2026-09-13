class Solution:
    def isValid(self, s: str) -> bool:
        complementaries = {"(": ")", "{": "}", "[": "]"}
        stack = []

        for el in s:
            if el in complementaries.keys():
                stack.append(el)
            
            else:
                if len(stack) == 0:
                    return False
                last_item = stack.pop()
                if el != complementaries[last_item]:
                    return False
                    
        if len(stack) != 0:
            return False
        return True

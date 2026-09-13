class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        operators = ["+", "-", "*", "/"]
        for token in tokens:
            if token not in operators:
                stack += [token]
            else:
                num1 = stack.pop()
                num2 = stack.pop()
                result = str(int(eval(num2 + token + num1)))
                stack.append(result)
        
        return int(stack[0])
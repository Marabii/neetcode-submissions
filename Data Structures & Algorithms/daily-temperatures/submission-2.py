class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        result = [0 for i in range(len(temperatures))]

        stack = [(temperatures[0], 0)]
        for i in range(1, len(temperatures)):
            if temperatures[i] <= stack[-1][0]:
                stack.append((temperatures[i], i))
            else:
                stack.append((temperatures[i], i))
                while len(stack) >= 2 and stack[-1][0] > stack[-2][0]:
                    last_item = stack.pop()
                    before_last_item = stack.pop()
                    result[before_last_item[1]] = last_item[1] - before_last_item[1]
                    stack.append(last_item)

        return result

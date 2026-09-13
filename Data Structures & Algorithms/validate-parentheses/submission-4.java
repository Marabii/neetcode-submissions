class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> openToClosedMap = new HashMap<>();
        openToClosedMap.put('(', ')');
        openToClosedMap.put('[', ']');
        openToClosedMap.put('{', '}');

        for (char c : s.toCharArray()) {
            if (openToClosedMap.containsKey(c)) {
                stack.add(c);
            } else {
                if (stack.size() == 0)
                    return false;
                Character lastVal = stack.pop();
                if (openToClosedMap.get(lastVal) != c)
                    return false;
            }
        }

        return stack.size() == 0;
    }

}

class Solution {
    public boolean isValid(String s) {
        List<Character> stack = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (isOpening(c))
                stack.add(c);
            else {
                if (stack.isEmpty() || matchOf(stack.getLast()) != c)
                    return false;
                stack.removeLast();
            }

        }

        return stack.isEmpty();
    }

    private boolean isOpening(char c) {
        return List.of('(', '[', '{').contains(c);
    }

    private char matchOf(char c) {
        switch (c) {
            case '(':
                return ')';
            case '[':
                return ']';
            case '{':
                return '}';

            default:
                throw new IllegalArgumentException();
        }
    }
}

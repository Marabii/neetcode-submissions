class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder scratch = new StringBuilder();
        generateParenthesisHelper(n, result, scratch, 0, 0);
        return result;
    }

    private void generateParenthesisHelper(int n, List<String> result, StringBuilder scratch, int open, int closed) {
        if (scratch.length() == 2 * n) {
            result.add(scratch.toString());
            return;
        }

        // Open parenthesis
        if (open < n) {
            scratch.append("(");
            generateParenthesisHelper(n, result, scratch, open + 1, closed);
            scratch.deleteCharAt(scratch.length() - 1);
        }

        // Close parenthesis
        if (closed < open) {
            scratch.append(")");
            generateParenthesisHelper(n, result, scratch, open, closed + 1);
            scratch.deleteCharAt(scratch.length() - 1);
        }
    }
}

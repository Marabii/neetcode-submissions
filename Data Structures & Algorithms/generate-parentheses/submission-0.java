class Solution {
    public static List<String> generateParenthesis(int n) {
        String curr = "";
        Set<String> res = new HashSet<>();
        backTrack(res, curr, 0, 0, n);
        return new ArrayList<>(res);
    }

    private static void backTrack(Set<String> res, String curr, int open, int closed, int n) {
        if (closed > open)
            return;

        if (curr.length() == 2 * n) {
            res.add(new String(curr));
            return;
        }

        if (open < n) {
            curr += "(";
            open++;
            backTrack(res, curr, open, closed, n);
            curr = curr.substring(0, curr.length() - 1);
            open--;
        }

        if (closed < open) {
            curr += ")";
            closed++;
            backTrack(res, curr, open, closed, n);
            curr = curr.substring(0, curr.length() - 1);
            closed--;
        }
    }
}

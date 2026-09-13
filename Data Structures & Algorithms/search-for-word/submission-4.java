class Solution {
    public static boolean exist(char[][] board, String word) {
        int boardWidth = board[0].length;
        int boardHeight = board.length;

        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                if (word.startsWith(Character.toString(board[i][j]))) {
                    // recursive backtracking dfs.
                    int wordIndex = 0;
                    Point currPoint = new Point(i, j);
                    Set<Point> visited = new HashSet<>();
                    boolean doesWordExist = backTrack(word, board, wordIndex, currPoint, visited);
                    if (doesWordExist)
                        return true;
                }
            }
        }

        return false;
    }

    private static boolean backTrack(String word, char[][] board, int wordIndex, Point p, Set<Point> visited) {
        int boardWidth = board[0].length;
        int boardHeight = board.length;

        if (wordIndex >= word.length() || (word.charAt(wordIndex) != board[p.x][p.y]))
            return false;
        else {
            wordIndex++;
            if (wordIndex == word.length())
                return true;
        }

        visited.add(p);

        boolean isWordDown = (p.x + 1 < boardHeight && !visited.contains(new Point(p.x + 1, p.y)))
                ? backTrack(word, board, wordIndex, new Point(p.x + 1, p.y), visited)
                : false;
        boolean isWordRight = (p.y + 1 < boardWidth && !visited.contains(new Point(p.x, p.y + 1)))
                ? backTrack(word, board, wordIndex, new Point(p.x, p.y + 1), visited)
                : false;
        boolean isWordUp = (p.x > 0 && !visited.contains(new Point(p.x - 1, p.y)))
                ? backTrack(word, board, wordIndex, new Point(p.x - 1, p.y), visited)
                : false;
        boolean isWordLeft = (p.y > 0 && !visited.contains(new Point(p.x, p.y - 1)))
                ? backTrack(word, board, wordIndex, new Point(p.x, p.y - 1), visited)
                : false;
        visited.remove(p);
        return isWordDown || isWordRight || isWordUp || isWordLeft;
    }

    private record Point(int x, int y) {

    }
}

class Solution {
    public boolean exist(char[][] board, String word) {
        boolean result = false;

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                Set<Point> newPath = new HashSet<>();
                newPath.add(new Point(x, y));
                result |= existsHelper(board, word, x, y, new StringBuilder(String.valueOf(board[x][y])),
                        newPath);
                                        if (result)
                    break;
            }
        }

        return result;
    }

    private boolean existsHelper(char[][] board, String word, int x, int y, StringBuilder scratch, Set<Point> visited) {
        if (word.equals(scratch.toString())) {
            return true;
        }

        if (scratch.length() >= word.length() || !word.substring(0, scratch.length()).equals(scratch.toString())) {
            return false;
        }

        // search down
        Point nextD = new Point(x + 1, y);
        if (x + 1 < board.length && !visited.contains(nextD)) {
            scratch.append(board[x + 1][y]);
            visited.add(nextD);
            if (existsHelper(board, word, x + 1, y, scratch, visited))
                return true;
            scratch.deleteCharAt(scratch.length() - 1);
            visited.remove(nextD);
        }

        // search up
        Point nextU = new Point(x - 1, y);
        if (x - 1 >= 0 && !visited.contains(nextU)) {
            scratch.append(board[x - 1][y]);
            visited.add(nextU);
            if (existsHelper(board, word, x - 1, y, scratch, visited))
                return true;
            scratch.deleteCharAt(scratch.length() - 1);
            visited.remove(nextU);
        }

        // search right
        Point nextR = new Point(x, y + 1);
        if (y + 1 < board[0].length && !visited.contains(nextR)) {
            scratch.append(board[x][y + 1]);
            visited.add(nextR);
            if (existsHelper(board, word, x, y + 1, scratch, visited))
                return true;
            scratch.deleteCharAt(scratch.length() - 1);
            visited.remove(nextR);
        }

        // search left
        Point nextL = new Point(x, y - 1);
        if (y - 1 >= 0 && !visited.contains(nextL)) {
            scratch.append(board[x][y - 1]);
            visited.add(nextL);
            if (existsHelper(board, word, x, y - 1, scratch, visited))
                return true;
            scratch.deleteCharAt(scratch.length() - 1);
            visited.remove(nextL);
        }

        return false;
    }

    private record Point(int x, int y) {
    }
}

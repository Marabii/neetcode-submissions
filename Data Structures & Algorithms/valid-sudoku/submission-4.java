class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> rows = new HashSet<>();
        Set<Character> columns = new HashSet<>();
        Set<Character> blocks = new HashSet<>();

        int boardSize = board.length;

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (board[i][j] != '.') {
                    if (columns.contains(board[i][j]))
                        return false;
                    columns.add(board[i][j]);
                }
            }

            columns.clear();
        }

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (board[j][i] != '.') {
                    if (rows.contains(board[j][i]))
                        return false;
                    rows.add(board[j][i]);
                }
            }

            rows.clear();
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int v = 3 * i; v < 3 * (i + 1); v++) {
                    for (int w = 3 * j; w < 3 * (j + 1); w++) {
                        if (board[v][w] != '.') {
                            if (blocks.contains(board[v][w]))
                                return false;
                            blocks.add(board[v][w]);
                        }
                    }
                }

                blocks.clear();
            }
        }

        return true;
    }
}

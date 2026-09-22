class Solution {
    private static int[][] DIRS = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public void solve(char[][] board) {
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (!visited[x][y] && board[x][y] == 'O') {
                    // Start BFS:
                    Point startingPoint = new Point(x, y);
                    queue.add(startingPoint);
                    visited[x][y] = true;
                    boolean foundLeak = (x == 0 || x == board.length - 1 || y == 0
                            || y == board[0].length - 1);
                    List<Point> mustBeTurned = new ArrayList<>();
                    mustBeTurned.add(startingPoint);

                    while (!queue.isEmpty()) {
                        Point p = queue.poll();

                        for (int[] dir : DIRS) {
                            int nx = p.x + dir[0];
                            int ny = p.y + dir[1];

                            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && board[nx][ny] == 'O'
                                    && !visited[nx][ny]) {
                                Point neighbor = new Point(nx, ny);

                                if (!foundLeak && nx == 0 || nx == board.length - 1 || ny == 0
                                        || ny == board[0].length - 1) {
                                    foundLeak = true;
                                }

                                visited[nx][ny] = true;
                                queue.add(neighbor);

                                if (!foundLeak) {
                                    mustBeTurned.add(neighbor);
                                }
                            }
                        }
                    }

                    if (!foundLeak) {
                        for (Point turPoint : mustBeTurned) {
                            board[turPoint.x][turPoint.y] = 'X';
                        }
                    }
                }
            }
        }
    }

    private record Point(int x, int y) {

    }
}

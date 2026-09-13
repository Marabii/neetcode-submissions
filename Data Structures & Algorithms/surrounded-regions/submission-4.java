class Solution {
    public void solve(char[][] board) {
        int boardWidth = board[0].length;
        int boardHeight = board.length;
        Set<Point> visited = new HashSet<>();

        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                Point p = new Point(i, j);
                if (visited.contains(p))
                    continue;

                if (board[p.x][p.y] == 'O') {
                    // bfs:
                    Queue<Point> queue = new ArrayDeque<>();
                    Set<Point> oToX = new HashSet<>();
                    boolean isSurounded = true;
                    queue.add(p);
                    visited.add(p);
                    oToX.add(p);

                    while (!queue.isEmpty()) {
                        Point currPoint = queue.poll();

                        for (int[] direction : DIRECTIONS) {
                            Point neighbor = new Point(currPoint.x + direction[0], currPoint.y + direction[1]);
                            if (outsideTheMap(neighbor, boardHeight, boardWidth)) {
                                isSurounded = false;
                            }

                            else if (!visited.contains(neighbor) && board[neighbor.x][neighbor.y] == 'O') {
                                queue.add(neighbor);
                                visited.add(neighbor);
                                oToX.add(neighbor);
                            }
                        }
                    }

                    if (isSurounded) {
                        for (Point O : oToX) {
                            System.out.println("O: " + O);
                            board[O.x][O.y] = 'X';
                        }
                    }
                }

                visited.add(p);
            }
        }
    }

    private record Point(int x, int y) {

    }

    private static boolean outsideTheMap(Point p, int gridHeight, int gridWidth) {
        return p.x < 0 || p.y < 0 || p.x >= gridHeight || p.y >= gridWidth;
    }

    private static final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
}

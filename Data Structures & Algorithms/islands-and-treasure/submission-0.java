class Solution {

    private static final int[][] DIRECTIONS = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public static void islandsAndTreasure(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    // perform bfs:
                    Point treasorPoint = new Point(i, j);
                    Queue<Point> queue = new ArrayDeque<>();
                    Set<Point> visited = new HashSet<>();
                    queue.add(treasorPoint);
                    visited.add(treasorPoint);
                    int distanceFromTreasor = 1;
                    while (!queue.isEmpty()) {
                        int queueSize = queue.size();
                        for (int k = 0; k < queueSize; k++) {
                            Point currPoint = queue.poll();
                            for (int[] direction : DIRECTIONS) {
                                Point neighbor = new Point(currPoint.x + direction[0], currPoint.y + direction[1]);
                                if (isPointInsideGrid(neighbor, grid.length, grid[0].length)
                                        && grid[neighbor.x][neighbor.y] > 0 && !visited.contains(neighbor)) {
                                    grid[neighbor.x][neighbor.y] = Math.min(grid[neighbor.x][neighbor.y],
                                            distanceFromTreasor);
                                    queue.add(neighbor);
                                    visited.add(neighbor);
                                }
                            }
                        }
                        distanceFromTreasor++;
                    }
                }
            }
        }
    }

    private static boolean isPointInsideGrid(Point p, int gridHeight, int gridWidth) {
        return p.x >= 0 && p.x <= gridHeight - 1 && p.y >= 0 && p.y <= gridWidth - 1;
    }

    private record Point(int x, int y) {

    }
}

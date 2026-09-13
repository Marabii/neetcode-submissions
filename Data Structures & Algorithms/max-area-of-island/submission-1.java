class Solution {
    private final static int[][] DIRECTIONS = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public static int maxAreaOfIsland(int[][] grid) {
        Set<Point> visited = new HashSet<>();
        int biggestIsland = 0;
        int currSize = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                Point p = new Point(i, j);
                if (!visited.contains(p) && grid[i][j] == 1) {
                    Queue<Point> queue = new ArrayDeque<>();
                    queue.add(p);
                    visited.add(p);
                    currSize += grid[p.x][p.y] == 1 ? 1 : 0;
                    while (!queue.isEmpty()) {
                        Point currPoint = queue.poll();
                        for (int[] direction : DIRECTIONS) {
                            if (currPoint.x + direction[0] >= 0 && currPoint.x + direction[0] <= grid.length - 1
                                    && currPoint.y + direction[1] >= 0
                                    && currPoint.y + direction[1] <= grid[0].length - 1) {
                                Point neighbor = new Point(currPoint.x + direction[0], currPoint.y + direction[1]);
                                if (!visited.contains(neighbor) && grid[neighbor.x][neighbor.y] == 1) {
                                    queue.add(neighbor);
                                    visited.add(neighbor);
                                    currSize++;
                                }
                            }
                        }

                    }
                    biggestIsland = Math.max(biggestIsland, currSize);
                    currSize = 0;
                }
                visited.add(p);
            }

        }

        return biggestIsland;

    }

    private record Point(int x, int y) {
    }
}

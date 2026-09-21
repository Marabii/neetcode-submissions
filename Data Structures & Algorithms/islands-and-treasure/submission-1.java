class Solution {
    private int[][] DIRS = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public void islandsAndTreasure(int[][] grid) {
        List<Point> allTreasure = findTresure(grid);
        for (Point treasure : allTreasure) {
            int dist = 1;

            Queue<Point> queue = new ArrayDeque<>();
            queue.add(treasure);

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Point currP = queue.poll();
                    for (int[] dir : DIRS) {
                        int nx = currP.x + dir[0];
                        int ny = currP.y + dir[1];

                        if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] != -1
                                && grid[nx][ny] > dist) {
                            queue.add(new Point(nx, ny));
                            grid[nx][ny] = dist;
                        }
                    }
                }
                dist++;
            }
        }
    }

    private List<Point> findTresure(int[][] grid) {
        List<Point> treasure = new ArrayList<>();

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == 0) {
                    treasure.add(new Point(x, y));
                }
            }
        }

        return treasure;
    }

    private record Point(int x, int y) {
    }
}

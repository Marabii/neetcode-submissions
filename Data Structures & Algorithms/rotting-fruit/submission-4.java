class Solution {
    private int[][] DIRS = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public int orangesRotting(int[][] grid) {
        Discover discover = discover(grid);
        int timer = 0;
        Queue<Point> rottenOranges = discover.rotten;
        int freshCount = discover.freshCount;

        while (!rottenOranges.isEmpty()) {
            int size = rottenOranges.size();
            boolean foundFreshOrange = false;
            for (int i = 0; i < size; i++) {
                Point currP = rottenOranges.poll();
                for (int[] dir : DIRS) {
                    int nx = currP.x + dir[0];
                    int ny = currP.y + dir[1];

                    if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == 1) {
                        rottenOranges.add(new Point(nx, ny));
                        grid[nx][ny] = 2;
                        freshCount--;
                        foundFreshOrange = true;
                    }
                }
            }

            if (foundFreshOrange)
                timer++;
        }

        if (freshCount > 0)
            return -1;
        return timer;
    }

    private Discover discover(int[][] grid) {
        Queue<Point> rotten = new ArrayDeque<>();
        int freshCount = 0;

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == 2) {
                    rotten.add(new Point(x, y));
                }

                if (grid[x][y] == 1) {
                    freshCount++;
                }
            }
        }

        return new Discover(rotten, freshCount);
    }

    private class Discover {
        Queue<Point> rotten;
        int freshCount;

        public Discover(Queue<Point> rotten, int freshCount) {
            this.freshCount = freshCount;
            this.rotten = rotten;
        }
    }

    private record Point(int x, int y) {
    }
}

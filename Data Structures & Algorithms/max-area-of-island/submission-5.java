class Solution {
    private int[][] DIRS = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        Queue<Integer> queue = new ArrayDeque<>();

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                int curr = 0;
                if (grid[x][y] == 1) {
                    int headPoint = x * grid[0].length + y;
                    queue.add(headPoint);
                    grid[x][y] = 0; // Mark as visited.
                    curr++;

                    while (!queue.isEmpty()) {
                        int p = queue.poll();

                        for (int[] dir : DIRS) {
                            int nx = p / grid[0].length + dir[0];
                            int ny = p % grid[0].length + dir[1];

                            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length) {
                                if (grid[nx][ny] == 1) {
                                    curr++;
                                    queue.add(nx * grid[0].length + ny);
                                    grid[nx][ny] = 0;
                                }
                            }
                        }
                    }
                }

                maxArea = Math.max(maxArea, curr);
            }
        }

        return maxArea;
    }
}

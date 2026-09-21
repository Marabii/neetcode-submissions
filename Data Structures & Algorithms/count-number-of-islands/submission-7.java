class Solution {
    public int numIslands(char[][] grid) {
        int numOfIslands = 0;
        Queue<Point> queue = new ArrayDeque<>();

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == '1') {
                    queue.add(new Point(x, y));
                    grid[x][y] = '0'; // Mark as visited.

                    while (!queue.isEmpty()) {
                        Point p = queue.poll();
                        
                        for (Point neighbor : neighbors(p, grid)) {
                            if (grid[neighbor.x][neighbor.y] == '1') {
                                queue.add(neighbor);
                                grid[neighbor.x][neighbor.y] = '0';
                            }
                        }
                    }

                    numOfIslands++;
                }
            }
        }

        return numOfIslands;
    }

    private List<Point> neighbors(Point p, char[][] grid) {
        List<Point> res = new ArrayList<>(4);
        if (p.x - 1 >= 0) {
            res.add(new Point(p.x - 1, p.y));
        }

        if (p.y - 1 >= 0) {
            res.add(new Point(p.x, p.y - 1));
        }

        if (p.x + 1 < grid.length) {
            res.add(new Point(p.x + 1, p.y));
        }

        if (p.y + 1 < grid[0].length) {
            res.add(new Point(p.x, p.y + 1));
        }

        return res;
    }

    private record Point(int x, int y) {
    }

}

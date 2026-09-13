class Solution {
    private final int[][] DIRECTIONS = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public int orangesRotting(int[][] grid) {
        List<Point> freshOranges = new ArrayList<>();
        Queue<Point> rottenOranges = new ArrayDeque<>();
        int numberOfMinutes = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    freshOranges.add(new Point(i, j));
                } else if (grid[i][j] == 2) {
                    rottenOranges.add(new Point(i, j));
                }
            }
        }

        int freshFruitsRemaining = freshOranges.size();
        Queue<Point> queue = new ArrayDeque<>(rottenOranges);
        Set<Point> visited = new HashSet<>(rottenOranges);
        while (!queue.isEmpty() && freshFruitsRemaining > 0) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Point currRottenOrange = queue.poll();
                for (int[] direction : DIRECTIONS) {
                    Point neighbor = new Point(currRottenOrange.x + direction[0],
                            currRottenOrange.y + direction[1]);
                    if (isPointInsideGrid(neighbor, grid.length, grid[0].length)
                            && grid[neighbor.x][neighbor.y] == 1 && !visited.contains(neighbor)) {
                        freshFruitsRemaining--;
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            numberOfMinutes++;
        }

        if (freshFruitsRemaining == 0) {
            return numberOfMinutes;
        }

        return -1;
    }   

    private boolean isPointInsideGrid(Point p, int gridHeight, int gridWidth) {
        return p.x >= 0 && p.x <= gridHeight - 1 && p.y >= 0 && p.y <= gridWidth - 1;
    }

    private record Point(int x, int y) {

    }
}

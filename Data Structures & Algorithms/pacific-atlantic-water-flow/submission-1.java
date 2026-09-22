class Solution {
    private int[][] DIRS = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<Point> paAt = new HashSet<>();
        Set<Point> atPa = new HashSet<>();

        Set<Point> startingPoints = new HashSet<>(2 * (heights.length + heights[0].length));

        for (int y = 0; y < heights[0].length; y++) {
            startingPoints.add(new Point(0, y));
            startingPoints.add(new Point(heights.length - 1, y));
        }

        for (int x = 0; x < heights.length; x++) {
            startingPoints.add(new Point(x, 0));
            startingPoints.add(new Point(x, heights[0].length - 1));
        }

        for (Point startingP : startingPoints) {
            Queue<Point> queue = new ArrayDeque<>();
            Set<Point> visited = new HashSet<>();
            queue.add(startingP);
            visited.add(startingP);

            while (!queue.isEmpty()) {
                Point currP = queue.poll();

                if (startingP.x == heights.length - 1 || startingP.y == heights[0].length - 1) {
                    // The starting point was the atlantic.
                    atPa.add(currP);
                }
                if (startingP.x == 0 || startingP.y == 0) {
                    paAt.add(currP);
                }

                for (int[] dir : DIRS) {
                    int nx = currP.x + dir[0];
                    int ny = currP.y + dir[1];

                    if (nx >= 0 && nx < heights.length && ny >= 0 && ny < heights[0].length) {
                        Point nP = new Point(nx, ny); // potential neighbor

                        if (!visited.contains(nP) && heights[nP.x][nP.y] >= heights[currP.x][currP.y]) {
                            if (startingP.x == heights.length - 1 || startingP.y == heights[0].length - 1) {
                                // The starting point was the atlantic.
                                atPa.add(nP);
                            }

                            if (startingP.x == 0 || startingP.y == 0) {
                                paAt.add(nP);
                            }

                            queue.add(nP);
                            visited.add(nP);
                        }
                    }
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (Point p : atPa) {
            if (paAt.contains(p)) {
                result.add(List.of(p.x, p.y));
            }
        }
        return result;
    }

    private record Point(int x, int y) {
    }
}

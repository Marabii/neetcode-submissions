class Solution {
        private int[][] DIRS = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] startInPacific = pacificAtlanticHelper(heights, true);
        boolean[][] startInAtlantic = pacificAtlanticHelper(heights, false);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (startInAtlantic[i][j] && startInPacific[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }

    private boolean[][] pacificAtlanticHelper(int[][] heights, boolean startsInPacific) {
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[heights.length][heights[0].length];

        if (startsInPacific) {
            for (int y = 0; y < heights[0].length; y++) {
                queue.add(new Point(0, y));
                visited[0][y] = true;
            }
            for (int x = 0; x < heights.length; x++) {
                queue.add(new Point(heights.length - 1, 0));
                visited[heights.length - 1][0] = true;
            }
        } else {
            for (int y = 0; y < heights[0].length; y++) {
                queue.add(new Point(heights.length - 1, y));
                visited[heights.length - 1][y] = true;
            }
            for (int x = 0; x < heights.length; x++) {
                queue.add(new Point(x, heights[0].length - 1));
                visited[x][heights[0].length - 1] = true;
            }
        }

        while (!queue.isEmpty()) {
            Point currP = queue.poll();

            for (int[] dir : DIRS) {
                int nx = currP.x + dir[0];
                int ny = currP.y + dir[1];

                if (nx >= 0 && nx < heights.length && ny >= 0 && ny < heights[0].length) {
                    Point nP = new Point(nx, ny); // potential neighbor

                    if (!visited[nP.x][nP.y] && heights[nP.x][nP.y] >= heights[currP.x][currP.y]) {
                        queue.add(nP);
                        visited[nP.x][nP.y] = true;
                    }
                }
            }
        }

        return visited;
    }

    private record Point(int x, int y) {
    }
}

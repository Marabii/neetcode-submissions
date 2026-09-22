class Solution {
    private int[][] DIRS = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<Point> startInPacific = pacificAtlanticHelper(heights, true);
        Set<Point> startInAtlantic = pacificAtlanticHelper(heights, false);

        List<List<Integer>> result = new ArrayList<>();
        for (Point p : startInPacific) {
            if (startInAtlantic.contains(p)) {
                result.add(List.of(p.x, p.y));
            }
        }
        return result;
    }

    private Set<Point> pacificAtlanticHelper(int[][] heights, boolean startsInPacific) {
        Queue<Point> queue = new ArrayDeque<>();
        Set<Point> visited = new HashSet<>();

        if (startsInPacific) {
            for (int y = 0; y < heights[0].length; y++) {
                queue.add(new Point(0, y));
                visited.add(new Point(0, y));
            }
            for (int x = 0; x < heights.length; x++) {
                queue.add(new Point(heights.length - 1, 0));
                visited.add(new Point(heights.length - 1, 0));
            }
        } else {
            for (int y = 0; y < heights[0].length; y++) {
                queue.add(new Point(heights.length - 1, y));
                visited.add(new Point(heights.length - 1, y));
            }
            for (int x = 0; x < heights.length; x++) {
                queue.add(new Point(x, heights[0].length - 1));
                visited.add(new Point(x, heights[0].length - 1));
            }
        }

        while (!queue.isEmpty()) {
            Point currP = queue.poll();

            for (int[] dir : DIRS) {
                int nx = currP.x + dir[0];
                int ny = currP.y + dir[1];

                if (nx >= 0 && nx < heights.length && ny >= 0 && ny < heights[0].length) {
                    Point nP = new Point(nx, ny); // potential neighbor

                    if (!visited.contains(nP) && heights[nP.x][nP.y] >= heights[currP.x][currP.y]) {
                        queue.add(nP);
                        visited.add(nP);
                    }
                }
            }
        }

        return visited;
    }

    private record Point(int x, int y) {
    }
}

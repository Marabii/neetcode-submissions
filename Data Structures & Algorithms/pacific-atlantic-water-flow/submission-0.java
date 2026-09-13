class Solution {
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Point> pacificReachable = new HashSet<>();
        Set<Point> atlanticReachable = new HashSet<>();

        int gridWidth = heights[0].length;
        int gridHeight = heights.length;
        for (int i = 0; i < gridHeight; i++) {
            for (int j = 0; j < gridWidth; j++) {
                Point p = new Point(i, j);
                Set<Point> visited = new HashSet<>();
                Set<Point> path = new HashSet<>();
                boolean didReachPacific = reachedPacific(p, path, heights, visited, heights[i][j]);
                if (didReachPacific) {
                    pacificReachable.add(p);
                    pacificReachable.addAll(path);
                }
                visited.clear();
                path.clear();
                boolean didReachAtlantic = reachedAtlantic(p, path, heights, visited, heights[i][j]);
                if (didReachAtlantic) {
                    atlanticReachable.add(p);
                    atlanticReachable.addAll(path);
                }
            }
        }

        for (Point p : pacificReachable) {
            if (atlanticReachable.contains(p)) {
                List<Integer> cell = new ArrayList<>();
                cell.add(p.x);
                cell.add(p.y);
                result.add(cell);
            }
        }

        return result;
    }

    private static boolean reachedPacific(Point p, Set<Point> path, int[][] heights, Set<Point> visited,
            int lastHeight) {
        int gridWidth = heights[0].length;
        int gridHeight = heights.length;

        if (visited.contains(p) || outsideTheMap(p, gridHeight, gridWidth) || heights[p.x][p.y] > lastHeight)
            return false;

        if (inPacific(p)) {
            path.add(p);
            return true;
        }

        visited.add(p);
        boolean result = false;
        lastHeight = heights[p.x][p.y];

        for (int[] direction : DIRECTIONS) {
            Point neighbor = new Point(p.x + direction[0], p.y + direction[1]);
            path.add(neighbor);
            boolean success = reachedPacific(neighbor, path, heights, visited, lastHeight);
            result = result || success;
            if (!success)
                path.remove(neighbor);
        }

        return result;
    }

    private static boolean reachedAtlantic(Point p, Set<Point> path, int[][] heights, Set<Point> visited,
            int lastHeight) {
        int gridWidth = heights[0].length;
        int gridHeight = heights.length;

        if (visited.contains(p) || outsideTheMap(p, gridHeight, gridWidth) || heights[p.x][p.y] > lastHeight)
            return false;

        if (inAtlantic(p, gridHeight, gridWidth)) {
            path.add(p);
            return true;
        }

        lastHeight = heights[p.x][p.y];

        visited.add(p);
        boolean result = false;

        for (int[] direction : DIRECTIONS) {
            Point neighbor = new Point(p.x + direction[0], p.y + direction[1]);
            path.add(neighbor);
            boolean success = reachedAtlantic(neighbor, path, heights, visited, lastHeight);
            result = result || success;
            if (!success)
                path.remove(neighbor);
        }

        return result;
    }

    private record Point(int x, int y) {

    }

    private static boolean inPacific(Point p) {
        return p.x == 0 || p.y == 0;
    }

    private static boolean inAtlantic(Point p, int gridHeight, int gridWidth) {
        return p.x == gridHeight - 1 || p.y == gridWidth - 1;
    }

    private static boolean outsideTheMap(Point p, int gridHeight, int gridWidth) {
        return p.x < 0 || p.y < 0 || p.x >= gridHeight || p.y >= gridWidth;
    }

    private static final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
}

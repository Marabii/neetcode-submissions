class Solution {
    public static int uniquePaths(int m, int n) {
        int[] numberOfPaths = { 0 };
        Point startPoint = new Point(0, 0);
        HashMap<String, Integer> map = new HashMap<>();
        countPathsFromPToEnd(startPoint, m, n, numberOfPaths, map);
        return numberOfPaths[0];
    }

    private static int countPathsFromPToEnd(Point p, int m, int n, int[] numberOfPathsFound,
            HashMap<String, Integer> map) {
        if (map.containsKey(p.toString())) {
            return map.get(p.toString());
        }

        backTrack(p, m, n, numberOfPathsFound);
        map.put(p.toString(), numberOfPathsFound[0]);
        return numberOfPathsFound[0];
    }

    private static void backTrack(Point p, int m, int n, int[] numberOfPathsFound) {
        if (p.x == m - 1 && p.y == n - 1) {
            numberOfPathsFound[0]++;
        }

        if (p.x < m - 1)
            backTrack(new Point(p.x + 1, p.y), m, n, numberOfPathsFound);
        if (p.y < n - 1)
            backTrack(new Point(p.x, p.y + 1), m, n, numberOfPathsFound);
    }

    private record Point(int x, int y) {

    }
}

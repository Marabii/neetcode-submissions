class Solution {
    public int uniquePaths(int m, int n) {
        Map<Point, Integer> map = new HashMap<>();
        return paths(new Point(0, 0), m, n, map);
    }

    private int paths(Point p, int m, int n, Map<Point, Integer> map) {
        if (map.containsKey(p))
            return map.get(p);
        if (p.x == m - 1 && p.y == n - 1)
            return 1;
        int result = 0;
        if (p.x + 1 < m)
            result += paths(new Point(p.x + 1, p.y), m, n, map);
        if (p.y + 1 < n)
            result += paths(new Point(p.x, p.y + 1), m, n, map);
        map.put(p, result);
        return result;
    }

    private record Point(int x, int y) {

    }
}

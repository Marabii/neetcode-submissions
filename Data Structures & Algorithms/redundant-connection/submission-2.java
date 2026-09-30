class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] visited = new int[n + 1];
        List<List<Integer>> adjList = new ArrayList<>(n + 1);
        adjList.add(new ArrayList<>());

        for (int i = 1; i <= n; i++) {
            visited[i] = -1;
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        visited[1] = 0;

        int n1 = 0;
        int n2 = 0;

        outer: while (!queue.isEmpty()) {
            int p = queue.poll();
            for (int neighbor : adjList.get(p)) {
                if (visited[neighbor] == 0) {
                    // Found the start of the cycle.
                    n1 = p;
                    n2 = neighbor;
                    break outer;
                } else if (visited[neighbor] == -1) {
                    visited[neighbor] = 0;
                    queue.add(neighbor);
                }
            }

            visited[p] = 1;
        }

        Set<int[]> cycle = findCycle(adjList, n1, n2, n);

        for (int i = edges.length - 1; i >= 0; i--) {
            int[] edge = edges[i];
            for (int[] cycleEdge : cycle) {
                if (edge[0] == cycleEdge[0] && edge[1] == cycleEdge[1]) {
                    return edge;
                }
            }
        }

        return null;

    }

    private Set<int[]> findCycle(List<List<Integer>> adjList, int n1, int n2, int n) {
        List<int[]> scratch = new ArrayList<>();
        Set<int[]> path = new HashSet<>();
        boolean[] visited = new boolean[n + 1];
        findCycleDFS(adjList, n1, n2, scratch, path, visited);
        path.add(new int[] { Math.min(n1, n2), Math.max(n1, n2) });
        return path;
    }

    private void findCycleDFS(List<List<Integer>> adjList, int curr, int end, List<int[]> scratch, Set<int[]> path,
            boolean[] visited) {
        if (curr == end && scratch.size() == 1) {
            return; // We don't want the edge between the 2 points.. we want the other way around.
        }

        if (curr == end) {
            path.addAll(scratch);
            return; // found the path!!!
        }

        visited[curr] = true;
        for (int next : adjList.get(curr)) {
            if (visited[next])
                continue;
            int[] edge = new int[] { Math.min(curr, next), Math.max(curr, next) };

            scratch.add(edge);
            findCycleDFS(adjList, next, end, scratch, path, visited);
            scratch.removeLast();
        }
    }
}

class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n == 1) {
            return true;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> children1 = map.getOrDefault(edge[0], new ArrayList<>());
            children1.add(edge[1]);
            map.put(edge[0], children1);
            List<Integer> children2 = map.getOrDefault(edge[1], new ArrayList<>());
            children2.add(edge[0]);
            map.put(edge[1], children2);
        }

        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            visited[i] = -1;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        visited[0] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            List<Integer> children = map.getOrDefault(node, new ArrayList<>());
            for (int child : children) {
                if (visited[child] == 0) {
                    // cycle found
                    return false;
                } else if (visited[child] == -1) {
                    // Exploring a new node.
                    queue.add(child);
                    visited[child] = 0;
                }
            }
            visited[node] = 1;
        }

        for (int node : visited) {
            if (node == -1) {
                return false; // Graph isn't fully connected.
            }
        }

        return true;
    }
}

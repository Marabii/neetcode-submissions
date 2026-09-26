class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] edge : edges) {
            List<Integer> l1 = map.getOrDefault(edge[0], new ArrayList<>());
            l1.add(edge[1]);
            map.put(edge[0], l1);

            List<Integer> l2 = map.getOrDefault(edge[1], new ArrayList<>());
            l2.add(edge[0]);
            map.put(edge[1], l2);
        }

        int separateComponents = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;

            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(i);
            visited[i] = true;

            while (!queue.isEmpty()) {
                int node = queue.poll();

                for (int neighbor : map.getOrDefault(node, new ArrayList<>())) {
                    if (!visited[neighbor]) {
                        queue.add(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }
            separateComponents++;
        }

        return separateComponents;
    }
}

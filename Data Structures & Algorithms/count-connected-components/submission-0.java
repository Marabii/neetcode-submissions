class Solution {
    public static int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] edge : edges) {
            List<Integer> startToEnd = map.getOrDefault(edge[0], new ArrayList<>());
            List<Integer> endToStart = map.getOrDefault(edge[1], new ArrayList<>());
            startToEnd.add(edge[1]);
            endToStart.add(edge[0]);
            map.put(edge[0], startToEnd);
            map.put(edge[1], endToStart);
        }

        int componentsCounter = 0;
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (visited.contains(i))
                continue;
            // otherwise, perform dfs on i.
            Set<Integer> dfsVisited = new HashSet<>();
            dfs(dfsVisited, i, map);
            visited.addAll(dfsVisited);
            componentsCounter++;
        }

        return componentsCounter;
    }

    private static void dfs(Set<Integer> dfsVisited, Integer currNode, Map<Integer, List<Integer>> map) {
        if (dfsVisited.contains(currNode))
            return;

        dfsVisited.add(currNode);
        for (int neighbor : map.getOrDefault(currNode, new ArrayList<>())) {
            dfs(dfsVisited, neighbor, map);
        }

    }
}

class Solution {
    // valid tree = no cycles and all nodes are connected.
    public static boolean validTree(int n, int[][] edges) {
        if (edges.length == 0) return true;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] edge : edges) {
                        if (edge[1] == edge[0]) {
                return false; // self loop
            }
            List<Integer> startToEnd = map.getOrDefault(edge[0], new ArrayList<>());
            List<Integer> endToStart = map.getOrDefault(edge[1], new ArrayList<>());
            startToEnd.add(edge[1]);
            endToStart.add(edge[0]);
            map.put(edge[0], startToEnd);
            map.put(edge[1], endToStart);

        }

        System.out.println(map);

        return isGraphConnected(map, n) && !isThereCycleInUndirectedGraph(map, 0, n);
    }

    private static boolean isGraphConnected(Map<Integer, List<Integer>> map, int n) {
        Set<Integer> visited = new HashSet<>();
        dfs(map, visited, 0);
        return visited.size() == n;
    }

    private static void dfs(Map<Integer, List<Integer>> map, Set<Integer> visited, Integer node) {
        if (visited.contains(node))
            return;

        visited.add(node);

        List<Integer> neighbors = map.get(node);
        if (neighbors == null)
            return;

        for (Integer i : neighbors) {
            dfs(map, visited, i);
        }
    }

    // unvisited: -1
    // visited and IN in queue: 0
    // visited and NOT in queue: 1
    // cycle detected if neighbor's state is 0

    private static boolean isThereCycleInUndirectedGraph(Map<Integer, List<Integer>> map, Integer startNode, int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> states = new HashMap<>();

        // mark all nodes as unvisited:
        for (int i = 0; i < n; i++) {
            states.put(i, -1);
        }

        queue.add(startNode);
        states.put(startNode, 0);

        while (!queue.isEmpty()) {
            Integer currNode = queue.poll();
            states.put(currNode, 1);

            for (Integer neighbor : map.get(currNode)) {
                if (states.get(neighbor) == -1 || states.get(neighbor) == 0) {
                    if (states.containsKey(neighbor) && states.get(neighbor) == 0) {
                        // cycle detected
                        return true;
                    }

                    queue.add(neighbor);
                    states.put(neighbor, 0);
                }
            }
        }

        return false;
    }

}

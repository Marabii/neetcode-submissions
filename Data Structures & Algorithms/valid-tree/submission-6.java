class Solution {
    public static boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        if (edges.length == 0) return true;
        for (int[] edge : edges) {
            List<Integer> startToEnd = map.getOrDefault(edge[0], new ArrayList<>());
            List<Integer> endToStart = map.getOrDefault(edge[1], new ArrayList<>());
            if (edge[0] == edge[1]) return false;
            startToEnd.add(edge[1]);
            endToStart.add(edge[0]);
            map.put(edge[0], startToEnd);
            map.put(edge[1], endToStart);
        }

        return isGraphConnected(map, n) && !isThereACycleInGraph(map);
    }

    private static boolean isGraphConnected(Map<Integer, List<Integer>> map, int n) {
        Set<Integer> visited = new HashSet<>();
        dfs(map, visited, 0);
        return visited.size() == n;
    }

    private static void dfs(Map<Integer, List<Integer>> map, Set<Integer> visited, Integer node) {
        if (visited.contains(node)) {
            return;
        }

        visited.add(node);
        List<Integer> neighbors = map.get(node);
        if (neighbors != null) {
            for (Integer neighbor : neighbors) {
                dfs(map, visited, neighbor);
            }
        }
    }

    // -1: unvisited
    // 0: visited and IN queue
    // 1 visited and Not in queue
    // there is a cycle in graph if neighbor's state is 0
    private static boolean isThereACycleInGraph(Map<Integer, List<Integer>> map) {
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> states = new HashMap<>();
        for (Integer node : map.keySet()) {
            states.put(node, -1);
        }

        queue.add(0);
        states.put(0, 0);
        while (!queue.isEmpty()) {
            Integer currNode = queue.poll();
            states.put(currNode, 1);
            for (Integer neighbor : map.get(currNode)) {
                Integer stateOfNeighbor = states.get(neighbor);
                if (stateOfNeighbor == -1 || stateOfNeighbor == 0) {
                    if (stateOfNeighbor == 0) {
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

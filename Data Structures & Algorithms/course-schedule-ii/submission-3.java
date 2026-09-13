class Solution {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            List<Integer> oldArr = graph.getOrDefault(prerequisite[1], new ArrayList<>());
            oldArr.add(prerequisite[0]);
            graph.put(prerequisite[1], oldArr);
        }

        for (int i = 0; i < numCourses; i++) {
            for (int node : graph.getOrDefault(i, new ArrayList<>())) {
                inDegree[node]++;
            }
        }

        int[] order = new int[numCourses];
        int index = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                order[index] = i;
                index++;
            }
        }

        while (!queue.isEmpty()) {
            Integer currNode = queue.poll();
            List<Integer> neighbors = graph.getOrDefault(currNode, new ArrayList<>());

            for (int i : neighbors) {
                inDegree[i]--;
                if (inDegree[i] == 0) {
                    order[index] = i;
                    index++;
                    queue.add(i);
                }
            }
        }

        if (index != numCourses) {
            return new int[0];
        }

        return order;
    }
}

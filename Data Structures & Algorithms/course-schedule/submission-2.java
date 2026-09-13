class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            List<Integer> oldVal = map.getOrDefault(prerequisite[0], new ArrayList<>());
            oldVal.add(prerequisite[1]);
            map.put(prerequisite[0], oldVal);
        }

        for (int course = 0; course < numCourses; course++) {
            boolean canTakeCourse = findTopologicalOrdering(map, numCourses);
            if (!canTakeCourse)
                return false;
        }

        return true;
    }

    private boolean findTopologicalOrdering(Map<Integer, List<Integer>> map, int numCourses) {
        int[] incomingDegree = new int[numCourses];
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> value = entry.getValue();
            for (int i : value) {
                incomingDegree[i]++;
            }
        }

        List<Integer> order = new ArrayList<>(numCourses);

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (incomingDegree[i] == 0) {
                queue.add(i);
                order.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int currCourse = queue.poll();
            for (int i : map.getOrDefault(currCourse, List.of(0))) {
                incomingDegree[i]--;
                if (incomingDegree[i] == 0) {
                    queue.add(i);
                    order.add(i);
                }
            }
        }

        return order.size() == numCourses;
    }
}

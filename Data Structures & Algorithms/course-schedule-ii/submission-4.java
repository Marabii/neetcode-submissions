class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] incDegree = new int[numCourses];
        int[] result = new int[numCourses];

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            List<Integer> r = map.getOrDefault(prerequisite[1], new ArrayList<>());
            r.add(prerequisite[0]);
            map.put(prerequisite[1], r);
            incDegree[prerequisite[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        int index = 0;
        for (int i = 0; i < numCourses; i++) {
            if (incDegree[i] == 0) {
                queue.add(i);
                result[index] = i;
                index++;
            }
        }

        while (!queue.isEmpty()) {
            int dependency = queue.poll();

            for (int course : map.getOrDefault(dependency, new ArrayList<>())) {
                incDegree[course]--;

                if (incDegree[course] == 0) {
                    queue.add(course);
                    result[index] = course;
                    index++;
                }
            }
        }

        if (index != numCourses) {
            return new int[] {};
        }

        return result;
    }
}

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> dependencyMap = new HashMap<>();
        int[] incDegree = new int[numCourses];

        for (int[] depArr : prerequisites) {
            int base = depArr[1];
            int dep = depArr[0];
            incDegree[dep]++;
            List<Integer> deps = dependencyMap.getOrDefault(base, new ArrayList<>());
            deps.add(dep);
            dependencyMap.put(base, deps);
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < numCourses; i++) {
            if (incDegree[i] == 0)
                queue.add(i);
        }

        int[] sol = new int[numCourses];
        int i = 0;

        while (!queue.isEmpty()) {
            Integer task = queue.poll();
            List<Integer> deps = dependencyMap.getOrDefault(task, new ArrayList<>());
            for (int dep : deps) {
                incDegree[dep]--;
                if (incDegree[dep] == 0) {
                    queue.add(dep);
                }
            }

            sol[i] = task;
            i++;
        }

        if (i != numCourses)
            return false;

        return true;
    }
}

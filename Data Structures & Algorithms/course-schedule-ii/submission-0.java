class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            ArrayList<Integer> oldArr = map.get(prerequisite[1]);
            if (oldArr == null) {
                oldArr = new ArrayList<>();
            }

            oldArr.add(prerequisite[0]);
            map.put(prerequisite[1], oldArr);
        }

        int[] incomingDegree = new int[numCourses];
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            ArrayList<Integer> value = entry.getValue();
            for (int i : value) {
                incomingDegree[i]++;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        int[] order = new int[numCourses];
        int index = 0;

        for (int i = 0; i < numCourses; i++) {
            if (incomingDegree[i] == 0) {
                queue.add(i);
                order[index] = i;
                index++;
            }
        }

        while (!queue.isEmpty()) {
            Integer currCourse = queue.poll();
            ArrayList<Integer> defaultValue = map.get(currCourse);
            if (defaultValue == null) {
                defaultValue = new ArrayList<>();
                defaultValue.add(0);
            }

            for (Integer i : defaultValue) {
                incomingDegree[i]--;
                if (incomingDegree[i] == 0) {
                    queue.add(i);
                    order[index] = i;
                    index++;
                }
            }
        }

        if (index != numCourses)
            return new int[] {};

        return order;
    }
}

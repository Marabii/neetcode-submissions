class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        // int[0] -> temp, int[1] -> index
        List<int[]> stack = new ArrayList<>();
        stack.add(new int[] { temperatures[0], 0 });

        // will simply be skipped in case temperatures has exactly one element
        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > stack.getLast()[0]) {
                result[stack.getLast()[1]] = i - stack.getLast()[1];
                stack.removeLast();
            }

            stack.add(new int[] { temperatures[i], i });
        }

        return result;
    }
}

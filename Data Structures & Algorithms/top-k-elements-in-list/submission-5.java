class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[k];
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(k, (a, b) -> {
            return Integer.compare(a.getValue(), b.getValue());
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int i = 0;
        while (!queue.isEmpty()) {
            var entry = queue.poll();
            result[i] = entry.getKey();
            i++;
        }

        return result;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int highestFreq = 0;
        for (int num : nums) {
            int newFreq = map.getOrDefault(num, 0) + 1;
            if (newFreq > highestFreq) {
                highestFreq = newFreq;
            }
            map.put(num, newFreq);
        }

        @SuppressWarnings("unchecked")
        List<Integer>[] buckets = new List[highestFreq + 1];

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }

            buckets[freq].add(num);
        }

        int j = 0;
        int[] result = new int[k];

        for (int i = highestFreq; i > 0; i--) {
            while (buckets[i] != null && !buckets[i].isEmpty()) {
                result[j] = buckets[i].removeLast();
                j++;
                if (j == k) {
                    return result;
                }
            }
        }

        return result;
    }
}

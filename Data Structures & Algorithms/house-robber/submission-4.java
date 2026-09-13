class Solution {
    public int rob(int[] houses) {
        Map<Integer, Integer> cache = new HashMap<>();
        return robHelper(houses, 0, cache);
    }

    private int robHelper(int[] houses, int i, Map<Integer, Integer> cache) {
        if (i >= houses.length) {
            return 0;
        }

        if (cache.containsKey(i)) {
            return cache.get(i);
        }

        int val = Math.max(houses[i] + robHelper(houses, i + 2, cache), robHelper(houses, i + 1, cache));

        cache.put(i, val);
        return val;
    }
}

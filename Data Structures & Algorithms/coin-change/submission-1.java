class Solution {
    public static int coinChange(int[] coins, int amount) {
        Map<String, Integer> map = new HashMap<>();
        int result = coinChangeHelper(coins, amount, 0, map);
        if (result == Integer.MAX_VALUE)
            return -1;
        return result;
    }

    private static int coinChangeHelper(int[] coins, int target, int i, Map<String, Integer> map) {
        String key = formatKey(target, i);
        if (map.containsKey(key))
            return map.get(key);

        if (target == 0)
            return 0;
        if (i >= coins.length || target < 0) {
            return Integer.MAX_VALUE;
        }

        int num1 = coinChangeHelper(coins, target - coins[i], i, map);
        if (num1 != Integer.MAX_VALUE) {
            num1++;
        }
        int num2 = coinChangeHelper(coins, target, i + 1, map);

        int result = Math.min(num1, num2);
        map.put(key, result);

        return Math.min(num1, num2);
    }

    private static String formatKey(int target, int i) {
        return i + "," + target;
    }
}

class Solution {
    public static int rob(int[] nums) {
        Map<String, Integer> map = new HashMap<>();
        return accomplice(nums, 0, map, false);
    }

    private static int accomplice(int[] nums, int i, Map<String, Integer> map, boolean robbedFirstHouse) {
        if (i >= nums.length)
            return 0;

        if (map.containsKey(formatKey(i, robbedFirstHouse)))
            return map.get(formatKey(i, robbedFirstHouse));

        if (i == 0) {
            int result = Math.max(nums[i] + accomplice(nums, i + 2, map, true), accomplice(nums, i + 1, map, false));
            map.put(formatKey(i, robbedFirstHouse), result);
            return result;
        }

        if (i == nums.length - 1) {
            int result = Math.max(robbedFirstHouse ? 0 : nums[i] + accomplice(nums, i + 2, map, robbedFirstHouse),
                    accomplice(nums, i + 1, map, robbedFirstHouse));
            map.put(formatKey(i, robbedFirstHouse), result);
            return result;
        }

        int result = Math.max(nums[i] + accomplice(nums, i + 2, map, robbedFirstHouse),
                accomplice(nums, i + 1, map, robbedFirstHouse));
        map.put(formatKey(i, robbedFirstHouse), result);
        return result;
    }

    private static String formatKey(int i, boolean bool) {
        return i + "," + bool;
    }
}

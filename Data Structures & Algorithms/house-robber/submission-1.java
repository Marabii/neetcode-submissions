class Solution {
    public static int rob(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        return accomplice(nums, 0, map);
    }

    private static int accomplice(int[] nums, int i, Map<Integer, Integer> map) {
        if (i >= nums.length)
            return 0;

        if (map.containsKey(i))
            return map.get(i);

        int result = Math.max(nums[i] + accomplice(nums, i + 2, map), accomplice(nums, i + 1, map));
        map.put(i, result);

        // rob or spare
        return result;
    }
}

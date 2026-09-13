class Solution {
    public static int characterReplacement(String s, int k) {
        int i = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 1);
        int max = 0;
        for (int j = 1; j < s.length(); j++) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            int maxFrequency = getMaxFrequency(map);
            while (j - i + 1 - maxFrequency > k) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                maxFrequency = getMaxFrequency(map);
                i++;
            }

            max = Math.max(max, j - i + 1);
        }

        return max;
    }

    private static int getMaxFrequency(Map<Character, Integer> map) {
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max)
                max = entry.getValue();
        }

        return max;
    }
}

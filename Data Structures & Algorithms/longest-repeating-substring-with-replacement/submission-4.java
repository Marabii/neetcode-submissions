class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int longest = 1;
        Map<Character, Integer> freq = new HashMap<>();
        freq.put(s.charAt(0), 1);

        for (int right = 1; right < s.length(); right++) {
            freq.put(s.charAt(right), freq.getOrDefault(s.charAt(right), 0) + 1);
            int[] result = mostFrequestAndRest(freq);
            int mostFrequent = result[0];
            int rest = result[1];

            while (rest > k) {
                freq.put(s.charAt(left), freq.get(s.charAt(left)) - 1);
                left++;
                rest--;
            }

            longest = Math.max(mostFrequent + rest, longest);
        }

        return longest;
    }

    // [0] -> highest frequency, [1] -> sum of the frequencies of the rest.
    private int[] mostFrequestAndRest(Map<Character, Integer> freq) {
        int[] result = new int[2];
        int highest = 0;
        for (int f : freq.values()) {
            if (f >= highest)
                highest = f;
            result[1] += f;
        }

        result[0] = highest;
        result[1] -= highest;

        return result;
    }
}

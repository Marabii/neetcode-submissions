class Solution {
    public boolean checkInclusion(String s2, String s1) {
        if (s1.length() < s2.length())
            return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < s2.length(); i++) {
            int index = (int) s1.charAt(i) - (int) 'a';
            freq1[index]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            int index = (int) s2.charAt(i) - (int) 'a';
            freq2[index]++;
        }

        int left = 0;
        int right = s2.length() - 1;

        while (right < s1.length() - 1) {
            if (Arrays.equals(freq1, freq2)) {
                return true;
            }

            right++;
            freq1[(int) s1.charAt(right) - (int) 'a']++;
            freq1[(int) s1.charAt(left) - (int) 'a']--;
            left++;
        }

        if (Arrays.equals(freq1, freq2)) {
            return true;
        }

        return false;
    }
}

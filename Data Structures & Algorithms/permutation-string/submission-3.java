class Solution {
    public boolean checkInclusion(String s2, String s1) {
        int n2 = s2.length();
        int n1 = s1.length();
        if (n1 < n2) return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (int i = 0; i < n2; i++) {
            count2[s2.charAt(i) - 'a']++;
            count1[s1.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (count1[i] == count2[i]) matches++;
        }

        for (int i = 0; i < n1 - n2; i++) {
            if (matches == 26) return true;

            int rightChar = s1.charAt(i + n2) - 'a';
            int leftChar = s1.charAt(i) - 'a';

            // Add incoming character
            count1[rightChar]++;
            if (count1[rightChar] == count2[rightChar]) {
                matches++;
            } else if (count1[rightChar] == count2[rightChar] + 1) {
                matches--;
            }

            // Remove outgoing character
            count1[leftChar]--;
            if (count1[leftChar] == count2[leftChar]) {
                matches++;
            } else if (count1[leftChar] == count2[leftChar] - 1) {
                matches--;
            }
        }

        return matches == 26;
    }
}
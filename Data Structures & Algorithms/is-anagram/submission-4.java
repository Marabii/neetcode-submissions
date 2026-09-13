class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] frequencies = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            int indexS = (int) sChar - (int) 'a';
            frequencies[indexS]++;
            int indexT = (int) tChar - (int) 'a';
            frequencies[indexT]--;
        }

        for (int freq : frequencies) {
            if (freq != 0)
                return false;
        }
        return true;
    }
}

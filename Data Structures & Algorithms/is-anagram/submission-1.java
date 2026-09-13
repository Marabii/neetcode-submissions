class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Integer s_freq = map.get(s.charAt(i));
            map.put(s.charAt(i), (s_freq == null) ? 1 : ++s_freq);
        }

        for (int i = 0; i < s.length(); i++) {
            Integer t_freq = map.get(t.charAt(i));
            if (t_freq == null) {
                return false;
            }
            map.put(t.charAt(i), --t_freq);
        }

        for (Integer i : map.values()) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}

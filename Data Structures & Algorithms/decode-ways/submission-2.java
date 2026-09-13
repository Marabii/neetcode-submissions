class Solution {
    public int numDecodings(String s) {
        return getStrings(s).size();
    }

    public static List<String> getStrings(String s) {
        Map<String, Character> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            char c = (char) ((int) 'A' + i);
            map.put(Integer.toString(i + 1), c);
        }

        List<String> sol = new ArrayList<>();
        getStringsHelper(s, 0, new ArrayList<>(), new StringBuilder(), sol, map);
        return sol;

    }

    private static void getStringsHelper(String s, int i, List<String> curr, StringBuilder word, List<String> sol,
            Map<String, Character> map) {
        if (i >= s.length()) {
            curr.forEach(num -> {
                word.append(map.get(num));

            });
            sol.add(word.toString());
            word.setLength(0);
            return;

        }

        if (s.charAt(i) == '0') {
            return;
        }

        curr.add(Character.toString(s.charAt(i)));
        getStringsHelper(s, i + 1, curr, word, sol, map);
        curr.remove(curr.size() - 1);

        if (i + 1 < s.length()) {
                        String twoDigit = s.substring(i, i + 2);
            if (Integer.parseInt(twoDigit) > 26) {
                return;
            }
            curr.add(s.substring(i, i + 2));
            getStringsHelper(s, i + 2, curr, word, sol, map);
            curr.remove(curr.size() - 1);

        }

    }

}

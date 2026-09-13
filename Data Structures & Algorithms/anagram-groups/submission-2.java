class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String hash = generateHash(str);
            List<String> old = map.getOrDefault(hash, new ArrayList<>());
            old.add(str);
            map.put(hash, old);
        }

        return map.values().stream()
                .collect(Collectors.toList());
    }

    private String generateHash(String s) {
        int[] frequencies = new int[26];
        for (char c : s.toCharArray()) {
            int pos = (int) c - (int) 'a';
            frequencies[pos]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append((char) (i + (int) 'a'));
            sb.append(frequencies[i]);
        }

        return sb.toString();
    }
}

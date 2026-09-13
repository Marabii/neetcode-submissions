class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String hash = hashStr(str);
            if (!map.containsKey(hash)) {
                List<String> arr = new ArrayList<>();
                arr.add(str);
                map.put(hash, arr);
            } else {
                List<String> arr = map.get(hash);
                arr.add(str);
                map.put(hash, arr);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> arr: map.values()) {
            result.add(arr);
        }

        return result;
    }

    private String hashStr(String str) {
        int start = (int) 'a';
        int[] freq_arr = new int[26];

        for (char c : str.toCharArray()) {
            int i = ((int) c) - start;
            freq_arr[i] = freq_arr[i] + 1;
        }

        String result = "";

        for (int i = 0; i < 26; i++) {
            if (freq_arr[i] != 0) {
                result += ((char) (start + i)) + String.valueOf(freq_arr[i]);
            }
        }
        return result;
    }
}

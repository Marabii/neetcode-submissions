class Solution {
    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length() + ";" + str);
        }

        return sb.toString();
    }

    public static List<String> decode(String str) {
        List<String> results = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int breakPoint = str.indexOf(';', i);
            int length = Integer.parseInt(str.substring(i, breakPoint));
            i = breakPoint + 1;
            results.add(str.substring(i, i + length));
            i += length;
        }

        return results;
    }

}

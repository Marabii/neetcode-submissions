class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int currIndex = 0;
        while (currIndex < str.length()) {
            int separatorIndex = str.indexOf("#", currIndex);
            int length = Integer.parseInt(str.substring(currIndex, separatorIndex));
            result.add(str.substring(separatorIndex + 1, separatorIndex + 1 + length));
            currIndex = separatorIndex + 1 + length;
        }

        return result;
    }
}

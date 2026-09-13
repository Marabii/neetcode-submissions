class Solution {
    
    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            int len = s.length();
            sb.append(len);
            sb.append("]");
            sb.append(s);
        }
        return sb.toString();
    }

    public static List<String> decode(String str) {
        StringBuilder countStr = new StringBuilder();
        StringBuilder tempStr = new StringBuilder();
        List<String> strs = new ArrayList<>();
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (count != 0) {
                tempStr.append(ch);
                count--;
            } else {
                if (ch != ']') {
                    countStr.append(ch);
                } else {
                    count = Integer.parseInt(countStr.toString());
                    strs.add(tempStr.toString());
                    countStr.setLength(0);
                    tempStr.setLength(0);
                }
            }
        }
        strs.add(tempStr.toString());
        tempStr.setLength(0);
        return strs.subList(1, strs.size());
    }
}

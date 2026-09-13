class Solution {
    
    public static String encode(List<String> strs) {
        String result = "";
        for (String s : strs) {
            result += String.valueOf(s.length()) + ";" + s;
        }
        return result;
    }

    public static List<String> decode(String str) {
        List<String> resuList = new ArrayList<>();
        if (str.length() == 0) {
            return resuList;
        }

        String resuString = "";
        String counterStr = "";
        int counter = 0;
        int i = 0;
        while (i < str.length()) {
            char c = str.charAt(i);
            if (c != ';' && counter == 0) {
                counterStr += c;
            }

            else if (c == ';' && counter == 0) {
                counter = Integer.parseInt(counterStr);
                counterStr = "";

                if (counter == 0) {
                    resuList.add(counterStr);
                }
            }

            else if (counter > 0) {
                resuString += c;
                counter--;

                if (counter == 0) {
                    resuList.add(resuString);
                    resuString = "";
                }
            }

            i++;
        }

        return resuList;
    }
}

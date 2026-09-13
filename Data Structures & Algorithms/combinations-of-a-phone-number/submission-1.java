class Solution {
    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return List.of();
        }

        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
        List<String> result = new ArrayList<>();
        backTrack(result, phoneMap, digits, new StringBuilder(), 0);
        return result;
    }

    private static void backTrack(List<String> res, Map<Character, String> phoneMap, String digits,
            StringBuilder curr, int index) {
        if (curr.length() == digits.length() || index == digits.length()) {
            res.add(curr.toString());
            return;
        }

        for (char letter : phoneMap.get(digits.charAt(index)).toCharArray()) {
                curr.append(letter);
                backTrack(res, phoneMap, digits, curr, index + 1);
                curr.deleteCharAt(curr.length() - 1);
            

        }
    }
}

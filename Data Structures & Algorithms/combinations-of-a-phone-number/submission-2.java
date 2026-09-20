class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return List.of();

        Map<Integer, List<Character>> map = new HashMap<>();
        fillMap(map);
        return letterCombinationsHelper(digits, map);
    }

    private List<String> letterCombinationsHelper(String digits, Map<Integer, List<Character>> map) {
        List<String> result = new ArrayList<>();
        int firstDigit = digits.charAt(0) - '0';
        result.addAll(map.get(firstDigit).stream()
                .map(String::valueOf)
                .toList());

        for (char d : digits.substring(1).toCharArray()) {
            int digit = d - '0';
            List<Character> chars = map.get(digit);
            List<String> arr = new ArrayList<>();
            for (char c : chars) {
                for (String s : result) {
                    arr.add(s + c);
                }
            }

            result = arr;
        }

        return result;
    }

    private void fillMap(Map<Integer, List<Character>> map) {
        map.put(2, List.of('a', 'b', 'c'));
        map.put(3, List.of('d', 'e', 'f'));
        map.put(4, List.of('g', 'h', 'i'));
        map.put(5, List.of('j', 'k', 'l'));
        map.put(6, List.of('m', 'n', 'o'));
        map.put(7, List.of('p', 'q', 'r', 's'));
        map.put(8, List.of('t', 'u', 'v'));
        map.put(9, List.of('w', 'x', 'y', 'z'));
    }
}

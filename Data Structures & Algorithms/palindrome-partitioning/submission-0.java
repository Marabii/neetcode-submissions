class Solution {
    public List<List<String>> partition(String s) {
        return partitionHelper(s);
    }

    private List<List<String>> partitionHelper(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s.isEmpty())
            return List.of(List.of());

        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, 0, i)) {
                String left = s.substring(0, i + 1);
                List<List<String>> right = partitionHelper(s.substring(i + 1));
                for (List<String> l : right) {
                    List<String> copy = new ArrayList<>(l.size() + 1);
                    copy.add(left);
                    copy.addAll(l);
                    result.add(copy);
                }

            }
        }

        return result;
    }

    private boolean isPalindrome(String s, int start, int end) {
        int left = start;
        int right = end;

        while (left <= end) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}

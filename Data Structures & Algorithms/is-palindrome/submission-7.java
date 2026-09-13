class Solution {
    public boolean isPalindrome(String s) {
        String cleanedStr = "";

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleanedStr += String.valueOf(c).toLowerCase();
            }
        }

        for (int i = 0; i < cleanedStr.length() / 2; i++) {
            if (cleanedStr.charAt(i) != cleanedStr.charAt(cleanedStr.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }
}

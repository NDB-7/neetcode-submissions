class Solution {
    public boolean isPalindrome(String s) {
        int r = s.length() - 1;

        for (int l = 0; l < r; l++) {
            while (r > l && !isAN(s.charAt(r))) r--;
            while (l < r && !isAN(s.charAt(l))) l++;
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            r--;
        }

        return true;
    }

    private boolean isAN(char c) {
        return Character.isLetterOrDigit(c);
    }
}

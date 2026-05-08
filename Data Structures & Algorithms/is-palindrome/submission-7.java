class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r && l < s.length() && r > 0) {
            if (!alnum(s.charAt(l))) l++;
            else if (!alnum(s.charAt(r))) r--;
            else {
                if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) return false;
                l++;
                r--;
            }
        }

        return true;
    }

    public boolean alnum(char c) {
        return Character.isLetterOrDigit(c);
    }
}

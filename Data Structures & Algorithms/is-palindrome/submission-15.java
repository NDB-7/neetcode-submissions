class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            while (r > l && !an(s.charAt(r))) r--;
            while (l < r && !an(s.charAt(l))) l++;

            char c1 = Character.toLowerCase(s.charAt(l));
            char c2 = Character.toLowerCase(s.charAt(r));
            if (c1 != c2) return false;
            l++;
            r--;
        }

        return true;
    }

    private boolean an(char c) {
        return Character.isLetterOrDigit(c);
    }
}

class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l <= r) {
            if (Character.isLetterOrDigit(s.charAt(l)) && Character.isLetterOrDigit(s.charAt(r))) {
                if (Character.toLowerCase(s.charAt(l)) == Character.toLowerCase(s.charAt(r))) {
                    l++;
                    r--;
                } else return false;
            }
            else if (Character.isLetterOrDigit(s.charAt(l))) r--;
            else l++;
        }

        return true;
    }
}

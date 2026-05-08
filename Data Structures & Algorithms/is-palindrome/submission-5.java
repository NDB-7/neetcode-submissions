class Solution {
    public boolean isPalindrome(String s) {
        int p2 = s.length() - 1;

        for (int p1 = 0; p1 <= p2; p1++) {
            while (p1 < s.length() - 1 && !Character.isLetterOrDigit(s.charAt(p1))) p1++;
            while (p2 > 0 && !Character.isLetterOrDigit(s.charAt(p2))) p2--;

            if (Character.isLetterOrDigit(s.charAt(p1)) && Character.isLetterOrDigit(s.charAt(p2)) && Character.toUpperCase(s.charAt(p1)) != Character.toUpperCase(s.charAt(p2))) return false;

            p2--;
        }

        return true;
    }
}

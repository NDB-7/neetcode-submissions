class Solution {
    public void reverseString(char[] s) {
        int p0 = 0;
        int p1 = s.length - 1;

        while (p0 < p1) {
            char c = s[p0];
            s[p0] = s[p1];
            s[p1] = c;
            p0++;
            p1--;
        }
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> chars = new HashSet<>();
        int maxLength = 0, l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            while (chars.contains(c)) {
                chars.remove(s.charAt(l));
                l++;
            }
            chars.add(c);
            maxLength = Math.max(maxLength, r - l + 1);
        }

        return maxLength;
    }
}

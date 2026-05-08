class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> chars = new HashSet<>();
        int maxLength = 0, length = 0, l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            while (chars.contains(c)) {
                chars.remove(s.charAt(l));
                l++;
                length--;
            }
            chars.add(c);
            length++;
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }
}

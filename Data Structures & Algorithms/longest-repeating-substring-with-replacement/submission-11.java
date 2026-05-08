public class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0, max = 0, maxf = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            int val = map.getOrDefault(c, 0) + 1;
            map.put(c, val);
            maxf = Math.max(maxf, val);

            while (r - l + 1 - maxf > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }

            max = Math.max(max, r - l + 1);
        }

        return max;
    }
}
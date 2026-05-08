class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        int n = s1.length();

        for (int i = 0; i < n; i++) {
            s1Count[s1.charAt(i) - 'a']++;
        }

        int l = 0;
        for (int r = 0; r < s2.length(); r++) {
            s2Count[s2.charAt(r) - 'a']++;

            if (r - l + 1 > n) s2Count[s2.charAt(l++) - 'a']--;

            if (Arrays.equals(s1Count, s2Count)) return true;
        }

        return false;
    }
}

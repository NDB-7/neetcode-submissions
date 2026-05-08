class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        int n = s1.length();

        for (int i = 0; i < n; i++) {
            char c = s1.charAt(i);
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        for (int r = 0; r < s2.length(); r++) {
            char c = s2.charAt(r);
            map2.put(c, map2.getOrDefault(c, 0) + 1);

            if (r - l + 1 > n) {
                char cl = s2.charAt(l);
                map2.put(cl, map2.get(cl) - 1);
                if (map2.get(cl) == 0) map2.remove(cl);
                l++;
            }

            if (map1.equals(map2)) return true;
        }

        return false;
    }
}

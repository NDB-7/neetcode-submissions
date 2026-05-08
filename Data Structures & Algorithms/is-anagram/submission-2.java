class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else map.put(c, 1);
        }

        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                int newValue = map.get(c) - 1;
                if (newValue == 0) map.remove(c);
                else map.put(c, newValue);
            } else return false;
        }

        return map.isEmpty();
    }
}

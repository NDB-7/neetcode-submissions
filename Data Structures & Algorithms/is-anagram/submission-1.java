class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (map.containsKey(currentChar)) map.put(currentChar, map.get(currentChar) + 1);
            else map.put(currentChar, 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char currentChar = t.charAt(i);
            if (map.get(currentChar) == null) return false;
            if (map.containsKey(currentChar)) map.put(currentChar, map.get(currentChar) - 1);
            if (map.get(currentChar) == 0) map.remove(currentChar);
        }

        return map.size() == 0;
    }
}

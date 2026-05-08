class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<String>> parent = new HashMap<>();
        
        for (String s : strs) {
            HashMap<Character, Integer> map = new HashMap<>();

            for (char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            if (parent.containsKey(map)) {
                parent.get(map).add(s);
            } else {
                parent.put(map, new ArrayList<>(Arrays.asList(s)));
            }
        }

        return new ArrayList<>(parent.values());
    }
}

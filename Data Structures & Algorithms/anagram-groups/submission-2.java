class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] count = new int[26];

            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            String strCount = Arrays.toString(count);

            if (map.containsKey(strCount)) {
                map.get(strCount).add(str);
            } else {
                List<String> wordList = new ArrayList<>();
                wordList.add(str);
                map.put(strCount, wordList);
            }
        }

        return new ArrayList<>(map.values());
    }
}

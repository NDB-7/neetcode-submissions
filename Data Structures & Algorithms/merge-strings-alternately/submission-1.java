class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();

        int i = 0;

        while (i < word1.length() && i < word2.length()) {
            res.append(word1.charAt(i));
            res.append(word2.charAt(i++));
        }

        while (i < word1.length()) res.append(word1.charAt(i++));
        while (i < word2.length()) res.append(word2.charAt(i++));

        return res.toString();
    }
}
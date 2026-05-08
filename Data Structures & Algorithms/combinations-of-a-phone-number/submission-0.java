class Solution {
    List<String> res;
    Map<Character, char[]> map;
    String digits;

    public List<String> letterCombinations(String digits) {
        this.res = new ArrayList<String>();
        this.map = new HashMap<Character, char[]>();
        this.digits = digits;

        map.put('2', new char[]{'a','b','c'});
        map.put('3', new char[]{'d','e','f'});
        map.put('4', new char[]{'g','h','i'});
        map.put('5', new char[]{'j','k','l'});
        map.put('6', new char[]{'m','n','o'});
        map.put('7', new char[]{'p','q','r', 's'});
        map.put('8', new char[]{'t','u','v'});
        map.put('9', new char[]{'w','x','y', 'z'});

        StringBuilder path = new StringBuilder();

        backtrack(0, path);

        return res;
    }

    private void backtrack(int i, StringBuilder path) {
        if (i == digits.length()) {
            if (path.length() > 0) res.add(path.toString());
            return;
        }

        char digit = digits.charAt(i);
        char[] letters = map.get(digit);

        for (char letter : letters) {
            path.append(letter);
            backtrack(i + 1, path);
            path.delete(path.length() - 1, path.length());
        }
    }
}

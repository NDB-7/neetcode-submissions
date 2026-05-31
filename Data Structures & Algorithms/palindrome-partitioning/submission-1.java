class Solution {
    List<List<String>> res;
    String s;

    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        this.s = s;

        backtrack(0, new ArrayList<String>());

        return res;
    }

    private void backtrack(int i, List<String> path) {
        if (i == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int j = i + 1; j <= s.length(); j++) {
            String sub = s.substring(i, j);
            if (isPalindrome(sub)) {
                path.add(sub);
                backtrack(j, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String input) {
        int l = 0, r = input.length() - 1;

        while (l < r) {
            if (input.charAt(l) != input.charAt(r)) return false;
            l++;
            r--;
        }
        
        return true;
    }
}

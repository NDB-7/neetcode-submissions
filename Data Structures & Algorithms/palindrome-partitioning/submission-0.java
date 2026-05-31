class Solution {
    /*
        Idea: we have a palindrome checker, and run each combo thru it
        Split it down to base (1 char)
        Discrete choice: add another letter to the string?
        If palindrome checker is false: scrap it
        If it's true: add to res
        Continue on path until end of string
    */
    List<List<String>> res;
    String input;

    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        input = s;

        backtrack(0, new ArrayList<String>());

        return res;
    }

    private void backtrack(int i, List<String> path) {
        if (i == input.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int j = i + 1; j <= input.length(); j++) {
            String sub = input.substring(i, j);
            if (isPalindrome(sub)) {
                path.add(sub);
                backtrack(j, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }
}

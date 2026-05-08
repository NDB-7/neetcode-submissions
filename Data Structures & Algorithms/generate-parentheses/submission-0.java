class Solution {
    List<String> res;
    int n;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        this.n = n;
        StringBuilder sb = new StringBuilder();

        backtrack(0, 0, sb);

        return res;
    }

    private void backtrack(int open, int close, StringBuilder sb) {
        if (sb.length() == n * 2) {
            res.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append("(");
            backtrack(open + 1, close, sb);
            sb.delete(sb.length() - 1, sb.length());
        }

        if (close < n && open > close) {
            sb.append(")");
            backtrack(open, close + 1, sb);
            sb.delete(sb.length() - 1, sb.length());
        }
    }

    /*
        Each discrete choice (n * 2 total):
            Add ( (push to stack)
            Add ) (pop from stack)
    */
}

class Solution {
    int n;
    List<String> res;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        this.res = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        backtrack(0, 0, sb);

        return res;
    }

    private void backtrack(int openN, int closeN, StringBuilder sb) {
        if (sb.length() == n * 2) {
            res.add(sb.toString());
            return;
        }

        if (openN < n) {
            sb.append("(");
            backtrack(openN + 1, closeN, sb);
            sb.delete(sb.length() - 1, sb.length());
        }

        if (closeN < n && openN > closeN) {
            sb.append(")");
            backtrack(openN, closeN + 1, sb);
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}

class Solution {
    int[] memo;
    public int climbStairs(int n) {
        this.memo = new int[n];
        memo[0] = 1;
        if (n > 1) memo[1] = 2;
        return climb(n);
    }

    public int climb(int n) {
        if (memo[n - 1] > 0) return memo[n - 1];
        int res = climb(n - 1) + climb(n - 2);
        memo[n - 1] = res;
        return res;
    }
}

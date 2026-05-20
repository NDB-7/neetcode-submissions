class Solution {
    int[] cost;
    int[] memo;

    public int minCostClimbingStairs(int[] cost) {
        this.cost = cost;
        memo = new int[cost.length];
        return Math.min(dfs(0), dfs(1));
    }

    private int dfs(int i) {
        if (i >= cost.length) return 0;
        if (memo[i] != 0) return memo[i];
        int currCost = cost[i] + Math.min(dfs(i + 1), dfs(i + 2));
        memo[i] = currCost;
        return currCost;
    }
}

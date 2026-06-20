class Solution {
    int[] nums;
    int[] memo;
    int len;

    public int rob(int[] nums) {
        this.nums = nums;
        this.len = nums.length;

        this.memo = new int[len];
        Arrays.fill(memo, -1);

        return robHelp(0);
    }

    private int robHelp(int i) {
        if (i >= len) return 0;
        if (memo[i] != -1) return memo[i];
        int res = Math.max(nums[i] + robHelp(i + 2), robHelp(i + 1));
        memo[i] = res;
        return res;
    }
}

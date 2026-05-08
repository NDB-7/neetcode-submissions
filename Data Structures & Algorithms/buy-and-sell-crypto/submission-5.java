class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, r = 1, max = 0;
        while (r < prices.length) {
            max = Math.max(max, prices[r] - prices[l]);
            if (prices[r] < prices[l]) l = r;
            r++;
        }

        return max;
    }
}

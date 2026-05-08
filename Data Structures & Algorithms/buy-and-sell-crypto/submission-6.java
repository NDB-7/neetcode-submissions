class Solution {
    public int maxProfit(int[] prices) {
        int maxP = 0;
        int minDay = 0;

        for (int i = 0; i < prices.length; i++) {
            int profit = prices[i] - prices[minDay];
            maxP = Math.max(profit, maxP);
            if (profit < 0) minDay = i;
        }

        return maxP;
    }
}

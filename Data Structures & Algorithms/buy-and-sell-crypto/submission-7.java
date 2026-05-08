class Solution {
    public int maxProfit(int[] prices) {
        int maxP = 0;
        int minPrice = prices[0];

        for (int p : prices) {
            maxP = Math.max(p - minPrice, maxP);
            minPrice = Math.min(minPrice, p);
        }

        return maxP;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minCost = prices[0];
        int maxProfit = 0;
        for(int i = 1;i<n;i++) {
            int diff = prices[i] - minCost;
            maxProfit = Math.max(maxProfit, diff);
            minCost = Math.min(minCost, prices[i]);
        }
        return maxProfit;
    }
}
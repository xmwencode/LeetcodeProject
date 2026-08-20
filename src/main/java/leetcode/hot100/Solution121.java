package leetcode.hot100;

class Solution121 {

    /**
     * 只能交易一次股票
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int p : prices) {
            maxProfit = Math.max(maxProfit, p - minPrice);
            minPrice = Math.min(minPrice, p);
        }
        return maxProfit;
    }
}
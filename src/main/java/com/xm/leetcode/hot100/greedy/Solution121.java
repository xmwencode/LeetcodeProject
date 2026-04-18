package com.xm.leetcode.hot100.greedy;

class Solution121 {
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        // 枚举卖出的价格
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, profit - cost);
        }
        return profit;
    }
}
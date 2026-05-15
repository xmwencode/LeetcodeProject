package com.xm.leetcode.everyday;

import java.util.Arrays;

class Solution3573 {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        // dp[i, j, 0]: 第 i 天，正在进行第 j 次交易，手中没有股票
        // dp[i, j, 1]: 第 i 天，正在进行第 j 次交易，手中有股票，非做空
        // dp[i, j, 2]: 第 i 天，正在进行第 j 次交易，手中有股票，做空
        long[][][] dp = new long[n + 1][k + 2][3];

        for (long[][] mat : dp) {
            for (long[] row : mat) {
                Arrays.fill(row, Long.MIN_VALUE / 2);
            }
        }
        for (int j = 1; j <= k + 1; j++) {
            dp[0][j][0] = 0;
        }
        for (int i = 0; i < n; i++) {
            int p = prices[i];
            for (int j = 1; j <= k + 1; j++) {
                dp[i + 1][j][0] = Math.max(dp[i][j][0], Math.max(dp[i][j][1] + p, dp[i][j][2] - p));
                dp[i + 1][j][1] = Math.max(dp[i][j][1], dp[i][j - 1][0] - p);
                dp[i + 1][j][2] = Math.max(dp[i][j][2], dp[i][j - 1][0] + p);
            }
        }
        return dp[n][k + 1][0];
    }
}
package com.xm.leetcode.hot100.dp;

import java.util.Arrays;

class Solution279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        // dp[i]: 和为 i 的完全平方数的最少数量
        // dp[i] = min(dp[i], dp[i - k * k] + 1)
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i ++ ) {
            for (int k = 1; k * k <= i; k ++ ) {
                dp[i] = Math.min(dp[i], dp[i - k * k] + 1);
            }
        }
        return dp[n];
    }
}
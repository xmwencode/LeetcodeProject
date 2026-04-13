package com.xm.leetcode.hot100.dp;

class Solution70 {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        // dp[i]: 爬到第 i 台阶需要的方法数量
        // dp[i] = dp[i - 1] + d[i - 2];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i ++ ) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
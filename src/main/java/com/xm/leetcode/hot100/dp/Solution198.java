package com.xm.leetcode.hot100.dp;

class Solution198 {
    public int rob(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        // dp[i, 0] 不打劫当前家；dp[i, 1] 打劫当前家
        // dp[i, 0] = max(dp[i - 1][0], dp[i - 1, 1])  如果不打劫当前家，则上一家可以打劫或不打劫
        // dp[i, 1] = dp[i - 1, 0] 如果打劫当前家，则上一家不能打劫
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}
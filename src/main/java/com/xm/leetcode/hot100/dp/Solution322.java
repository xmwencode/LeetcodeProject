package com.xm.leetcode.hot100.dp;

import java.util.Arrays;

class Solution322 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        // dp[i]: 凑成金额为 i 的硬币的最少个数
        // dp[i] = min(dp[i], d[i - w[j] * k] + 1) 完全背包问题
        Arrays.fill(dp, 0x3f3f3f3f);
        dp[0] = 0;
        for (int v : coins) {
            for (int j = v; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - v] + 1);
            }
        }
        if (dp[amount] > 0x3f3f3f3f / 2) return -1;
        return dp[amount];
    }
}
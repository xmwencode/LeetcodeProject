package leetcode.hot100;

import java.util.Arrays;

class Solution322 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        // dp[i][j]: 前 i 种硬币中选，总金额恰好为 j 的硬币的最小个数
        int[][] dp = new int[n + 1][amount + 1];
        Arrays.fill(dp[0], 0x3f3f3f3f);
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j < coins[i]) {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    dp[i + 1][j] = Math.min(dp[i][j], dp[i + 1][j - coins[i]] + 1);
                }
            }
        }
        int res = dp[n][amount];
        return res < 0x3f3f3f3f / 2 ? res : -1;
    }
}
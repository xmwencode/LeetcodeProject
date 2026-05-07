package com.xm.leetcode.everyday;

import java.util.Arrays;

class Solution3418 {
    public int maximumAmount(int[][] coins) {
        int n = coins.length;
        int m = coins[0].length;
        // dp[i, j, k]: 到达 (i, j) 位置感化不超过 k 个强盗的最大收益
        int[][][] dp = new int[n + 1][m + 1][3];
        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, -0x3f3f3f3f);
            }
        }
        Arrays.fill(dp[0][1], 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int w = coins[i][j];
                dp[i + 1][j + 1][0] = Math.max(dp[i + 1][j][0], dp[i][j + 1][0]) + w;
                dp[i + 1][j + 1][1] = Math.max(
                        Math.max(dp[i + 1][j][0], dp[i][j + 1][0]),
                        Math.max(dp[i + 1][j][1], dp[i][j + 1][1]) + w
                );
                dp[i + 1][j + 1][2] = Math.max(
                        Math.max(dp[i + 1][j][1], dp[i][j + 1][1]),
                        Math.max(dp[i + 1][j][2], dp[i][j + 1][2]) + w
                );
            }
        }
        return dp[n][m][2];
    }
}
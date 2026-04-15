package com.xm.leetcode.hot100.dp;

import java.util.Arrays;

class Solution62 {
    public int uniquePaths(int m, int n) {
        // dp[i, j] 表示走到 (i, j) 的路径数量
        int[][] dp = new int[n + 1][m + 1];
        // 第一行所有点只有一种走法
        Arrays.fill(dp[1], 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[n][m];
    }
}
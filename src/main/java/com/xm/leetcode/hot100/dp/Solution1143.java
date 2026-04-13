package com.xm.leetcode.hot100.dp;

class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        char[] a = text1.toCharArray();
        char[] b = text2.toCharArray();
        // dp[i, j] 表示以 a[i] 和 b[j] 结尾的最长公共子序列
        int[][] dp = new int[n][m];
        // 初始化
        dp[0][0] = a[0] == b[0] ? 1 : 0;
        for (int j = 1; j < m; j++) {
            dp[0][j] = a[0] == b[j] ? 1 : dp[0][j-1];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = b[0] == a[i] ? 1 : dp[i-1][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (a[i] == b[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
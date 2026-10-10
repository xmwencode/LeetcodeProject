package leetcode.hot100;

class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        // dp[i, j]: text1 中前 i 个字符，text2 中前 j 个字符的最长公共子序列长度
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[n][m];
    }
}
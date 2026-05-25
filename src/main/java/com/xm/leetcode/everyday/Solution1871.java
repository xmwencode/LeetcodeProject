package com.xm.leetcode.everyday;

class Solution1871 {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        int[] dp = new int[n];
        // dp[i] 表示能否从 0 跳到 i
        // 从 i 能跳到 j 等价于 区间 [j - maxJump, j - minJump] 和 大于 0
        int[] sum = new int[n + 1];
        dp[0] = sum[1] = 1;
        for (int j = 1; j < n; j++) {
            if (j >= minJump && s.charAt(j) == '0' &&
                    sum[j - minJump + 1] > sum[Math.max(j - maxJump, 0)]) {
                dp[j] = 1;
            }
            sum[j + 1] = sum[j] + dp[j];
        }
        return dp[n - 1] == 1;
    }
}
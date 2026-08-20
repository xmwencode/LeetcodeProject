package leetcode.hot100;

class Solution198 {
    public int rob(int[] nums) {
        int n = nums.length;
        // dp[i, 1]: 偷了第 i 家
        // dp[i, 0]: 没有偷第 i 家
        int[][] dp = new int[n][2];
        dp[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            // 没有偷当前家
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            // 偷了当前家
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}
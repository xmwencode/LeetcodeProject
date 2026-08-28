package leetcode.hot100;

import java.util.Arrays;

class Solution416 {
    public boolean canPartition(int[] nums) {
        // 01 背包: 在 nums 中取 m 个数，数字和恰好为 target
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        int n = nums.length;
        // dp[i, j] 在 nums[] 前 i 个数中取，和恰好为 j
        boolean[][] dp = new boolean[n + 1][target + 1];
        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                if (j < nums[i]) {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    dp[i + 1][j] = dp[i][j - nums[i]] || dp[i][j];
                }
            }
        }
        return dp[n][target];
    }
}
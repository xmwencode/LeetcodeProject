package com.xm.leetcode.hot100.dp;

import java.util.Arrays;

class Solution416 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        // 如果和为奇数，一定不能分组
        if ((sum & 1) == 1) return false;
        // 只需要找寻前 i 个数中有没有和为 target 的数即可
        int target = sum / 2;
        // dp[i, j]: 前 i 个数中是否存在若干个元素的和等于 j
        boolean[][] dp = new boolean[n][target + 1];
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        } else {
            return false;
        }
        for (int i = 1; i < n; i++) {
            int x = nums[i];
            for (int j = 0; j <= target; j++) {
                if (j < x) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j] || dp[i - 1][j - x];
            }
            if (dp[i][target]) {
                return true;
            }
        }
        return dp[n - 1][target];
    }
}
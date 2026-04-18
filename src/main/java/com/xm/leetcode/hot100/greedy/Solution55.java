package com.xm.leetcode.hot100.greedy;

class Solution55 {
    public boolean canJump(int[] nums) {
        int maxPos = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i <= maxPos) {
                maxPos = Math.max(maxPos, i + nums[i]);
            }
        }
        return n - 1 <= maxPos;
    }

    public boolean canJump2(int[] nums) {
        int n = nums.length;
        // dp[j]: 由 0 点能否跳到 j 点
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            if (dp[i]) {
                for (int step = 1; step <= nums[i] && i + step < n; step++) {
                    dp[i + step] = true;
                }
            }
        }
        return dp[n - 1];
    }

    public boolean canJump3(int[] nums) {
        int n = nums.length;
        // dp[j]: 由 0 点能否跳到 j 点
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && j + nums[j] >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n - 1];
    }
}
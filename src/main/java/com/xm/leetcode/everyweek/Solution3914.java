package com.xm.leetcode.everyweek;

class Solution3914 {
    public long minOperations(int[] nums) {
        int n = nums.length;
        long res = 0;
        // 优化
        for (int i = 1; i < n; i++) {
            res += Math.max(nums[i - 1] - nums[i], 0);
        }
        return res;
    }

    public long minOperations1(int[] nums) {
        int n = nums.length;
        // 差分数组
        int[] diff = new int[n];
        diff[0] = nums[0];
        for (int i = 1; i < n; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
        // 只需要保证：差分数组中 diff[1] ~ diff[n-1] 全部 ≥ 0 即可
        long res = 0;
        for (int i = 1; i < n; i++) {
            if (diff[i] < 0) {
                res += -diff[i];
            }
        }
        return res;
    }

}
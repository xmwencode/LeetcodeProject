package com.xm.leetcode.hoot100;

class Solution53 {
    public int maxSubArray(int[] nums) {
        // 记录历史扫描数组和
        int maxSum = -0x3f3f3f3f;
        // 记录当前扫描数组和
        int sum = maxSum;
        for (int x : nums) {
            if (sum <= 0) {
                sum = x;
            } else {
                sum += x;
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
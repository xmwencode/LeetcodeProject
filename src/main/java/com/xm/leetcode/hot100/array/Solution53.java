package com.xm.leetcode.hot100.array;

class Solution53 {
    public int maxSubArray(int[] nums) {
        // 记录历史最大子数组和
        int res = -0x3f3f3f3f;
        // 记录当前扫描子数组的和
        int sum = -0x3f3f3f3f;
        for (int num : nums) {
            sum += num;
            if (sum < num) {
                // 开辟新子数组
                sum = num;
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
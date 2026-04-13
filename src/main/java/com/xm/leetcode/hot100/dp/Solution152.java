package com.xm.leetcode.hot100.dp;

import java.util.Arrays;

class Solution152 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int fMax = 1; // 用来保存以上一个数结尾的最大子数组积
        int fMin = 1; // 用来保存以上一个数结尾的最小子数组积
        int res = 0;
        for (int x : nums) {
            int max = fMax, min = fMin;
            fMax = Math.max(x, Math.max(max * x, min * x));
            fMin = Math.min(x, Math.min(max * x, min * x));
            res = Math.max(res, fMax);
        }
        return res;
    }
}
package com.xm.leetcode.hoot100;

class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[n - 1] = 1;
        // 右侧累乘
        for (int i = n - 2; i >= 0; i--) {
            ans[i] = ans[i + 1] * nums[i + 1];
        }
        int mul = 1;
        // 左侧累乘
        for (int i = 0; i < n; i++) {
            ans[i] *= mul;
            mul *= nums[i];
        }
        return ans;
    }
}
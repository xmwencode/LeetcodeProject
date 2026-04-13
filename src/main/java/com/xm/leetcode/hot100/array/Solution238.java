package com.xm.leetcode.hot100.array;

class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        // 记录当前数左边的乘积
        int[] leftMul = new int[n];
        // 记录当前数右边的乘积
        int[] rightMul = new int[n];
        // 记录结果
        int[] res = new int[n];
        leftMul[0] = 1;
        for (int i = 1; i < n; i++) {
            leftMul[i] = leftMul[i - 1] * nums[i - 1];
        }
        rightMul[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            rightMul[i] = rightMul[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < n; i ++ ) {
            res[i] = leftMul[i] * rightMul[i];
        }
        return res;
    }

    public int[] productExceptSelf2(int[] nums) {
        // 记录左前缀积
        int leftMul = 1;
        // 记录右前缀积
        int rightMul = 1;
        int[] res = new int[nums.length];
        // 先从左到右乘左边的积
        for (int i = 0; i < nums.length; i++) {
            res[i] = leftMul;
            leftMul *= nums[i];
        }
        // 在从右到左乘右边的积
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= rightMul;
            rightMul *= nums[i];
        }
        return res;
    }
}
package com.xm.leetcode.hoot100;

class Solution42 {
    public int trap(int[] height) {
        int n = height.length;
        // 记录 i 左边的最高值
        int[] lMax = new int[n];
        for (int i = 1; i < n; i++) {
            lMax[i] = Math.max(lMax[i - 1], height[i - 1]);
        }
        // 记录 i 右边的最高值
        int[] rMax = new int[n];
        for (int i = n - 2; i > 0; i--) {
            rMax[i] = Math.max(rMax[i + 1], height[i + 1]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.max(0, Math.min(lMax[i], rMax[i]) - height[i]);
        }
        return ans;
    }
}
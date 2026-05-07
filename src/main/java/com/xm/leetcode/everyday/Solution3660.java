package com.xm.leetcode.everyday;

class Solution3660 {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] preMax = new int[n]; // [0, i - 1] 的最大值
        // int[] sufMin = new int[n]; // [i + 1, n] 的最小值
        preMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preMax[i] = Math.max(preMax[i - 1], nums[i]);
        }
        int sufMin = Integer.MAX_VALUE;
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (preMax[i] <= sufMin) {
                // 可以跳到最大值
                ans[i] = preMax[i];
            } else {
                ans[i] = ans[i + 1];
            }
            sufMin = Math.min(nums[i], sufMin);
        }
        return ans;
    }
}
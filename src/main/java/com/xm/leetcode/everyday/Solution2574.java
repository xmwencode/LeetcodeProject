package com.xm.leetcode.everyday;

import java.util.Arrays;

class Solution2574 {

    public int[] leftRightDifference(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int n = nums.length;
        int[] ans = new int[n];
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            ans[i] = Math.abs(2 * leftSum + x - sum);
            leftSum += x;
        }
        return ans;
    }

    public int[] leftRightDifference1(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] + nums[i + 1];
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = Math.abs(left[i] - right[i]);
        }
        return ans;
    }
}
package com.xm.leetcode.weekcontest.in181;

class Solution2 {
    public int compareBitonicSums(int[] nums) {
        long left = nums[0];
        long right = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                left += nums[i];
            }
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                right += nums[i];
            }
        }
        if (left > right) return 0;
        if (left < right) return 1;
        return -1;
    }
}
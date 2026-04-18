package com.xm.leetcode.hot100.binarysearch;

class Solution153 {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = -1, r = n - 1;
        while (l + 1 < r) {
            int mid = l + r >> 1;
            if (nums[mid] < nums[n - 1]) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return nums[r];
    }
}
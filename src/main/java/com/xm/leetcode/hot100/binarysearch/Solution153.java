package com.xm.leetcode.hot100.binarysearch;

class Solution153 {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + r >> 1;
            // 最小值一定在右有序数组的最左边
            // mid 在左有序数组
            if (nums[mid] > nums[n - 1]) {
                l = mid + 1;
            } else {
              // mid 在右有序数组
                r = mid - 1;
            }
        }
        return nums[l];
    }
}
package com.xm.leetcode.everyday;

class Solution154 {
    public int findMin(int[] nums) {
        // nums: 左始...左终 右始...右终
        // mid >= 左始 => 左侧
        // mid < 左始 => 右侧
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == nums[r]) {
                r--;
            } else if (nums[mid] < nums[r]) {
                // 最小值一定在左侧
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
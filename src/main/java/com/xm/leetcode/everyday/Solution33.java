package com.xm.leetcode.everyday;

class Solution33 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 与最左侧数字比较，判断是处于左有序区间还是右有序区间
            if (nums[mid] >= nums[left]) {
                // target 位于左有序区间且 target 在 mid 左边
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // target 位于右有序区间且 target 在 mid 右边
                if (target < nums[left] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
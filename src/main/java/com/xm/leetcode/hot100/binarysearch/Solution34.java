package com.xm.leetcode.hot100.binarysearch;

class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int start = binarySearch(nums, target);
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }
        // 搜索最后一个位置等效于搜索下一个数的第一个位置 - 1
        int end = binarySearch(nums, target + 1) - 1;
        if (end == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{start, end};
    }

    private int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + r >> 1;
            if (nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return l;
    }
}
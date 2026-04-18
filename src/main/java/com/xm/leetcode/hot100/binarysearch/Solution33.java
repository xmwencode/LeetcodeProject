package com.xm.leetcode.hot100.binarysearch;

class Solution33 {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target);
    }

    private int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid = 0;
        while (l <= r) {
            mid = l + r >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            // 根据 nums[mid] 与 nums[l] 判断 mid 是在左端还是右端
            if (nums[mid] >= nums[l]) {
                // mid 在右半段, 判断 target 是在 mid 左边还是右边
                if (target < nums[l] || target >= nums[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

}
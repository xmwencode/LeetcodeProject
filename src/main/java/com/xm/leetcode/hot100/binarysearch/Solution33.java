package com.xm.leetcode.hot100.binarysearch;

class Solution33 {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target);
    }


    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            // 1. mid 在左有序区间
            if (nums[mid] >= nums[left]) {
                // target 在左有序区间 且 target 在 mid左边
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // 2. mid 在右有序区间
            else {
                if (target < nums[left] && target > nums[mid]) {
                    // target 在右有序区间 且 target 在 mid 右侧
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    private int binarySearch2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            // 1. mid 在左有序区间
            if (nums[mid] >= nums[left]) {
                // target 在左有序区间
                if (target >= nums[left]) {
                    if (target < nums[mid]) {
                        // target 在 mid左边
                        right = mid - 1;
                    } else {
                        // target 在 mid右边
                        left = mid + 1;
                    }
                } else {
                    // target 在右有序区间，一定在 mid 右侧
                    left = mid + 1;
                }
            }
            // 2. mid 在右有序区间
            else {
                if (target >= nums[left]) {
                    // target 在左有序区间，一定在 mid 左侧
                    right = mid - 1;
                } else {
                    // target 在右有序区间
                    if (target > nums[mid]) {
                        // target 在 mid 右侧
                        left = mid + 1;
                    } else {
                        // target 在 mid 左侧
                        right = mid - 1;
                    }
                }
            }
        }
        return -1;
    }

}
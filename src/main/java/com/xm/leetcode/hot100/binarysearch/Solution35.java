package com.xm.leetcode.hot100.binarysearch;

class Solution35 {
    public int searchInsert(int[] nums, int target) {
        return lowerBound(nums, target);
    }

    // 闭区间写法 [l, r]
    private int lowerBound(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + r >> 1;
            if (nums[mid] < target) {
                // 将范围缩小到 [mid + 1, r]
                l = mid + 1;
            } else {
                // 将范围缩小到 [l, mid - 1]
                r = mid - 1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 7, 8, 8, 10, 11, 15, 18, 18};
        int target = 18;
        int l = 0, r = nums.length - 1;
        System.out.println("初始状态, l = " + l + " r = " + r);
        int count = 0;
        while (l <= r) {
            count++;
            int mid = l + r >> 1;
            System.out.print("[第" + count + "次搜索]: " + "mid = " + mid + " ");
            if (nums[mid] < target) {
                // 将范围缩小到 [mid + 1, r]
                l = mid + 1;
                System.out.println("范围缩小到 [ " + (mid + 1) + ", " + r + " ]");
            } else {
                // 将范围缩小到 [l, mid - 1]
                r = mid - 1;
                System.out.println("范围缩小到 [ " + l + ", " + (mid - 1) + " ]");
            }
        }
        System.out.println("index = " + l);
    }
}
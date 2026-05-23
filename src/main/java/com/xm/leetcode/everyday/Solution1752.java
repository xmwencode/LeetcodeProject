package com.xm.leetcode.everyday;

class Solution1752 {
    public boolean check(int[] nums) {
        // [2, 1, 3, 4]
        int n = nums.length;
        if (nums[0] >= nums[n - 1]) {
            // 存在旋转
            boolean st = true;
            for (int i = 1; i < n; i++) {
                if (st && nums[i] < nums[i - 1]) {
                    st = false;
                } else if (!st && nums[i] < nums[i - 1]) {
                    return false;
                }
            }
        } else {
            // 不存在旋转，必须递增
            for (int i = 1; i < n; i++) {
                if (nums[i] < nums[i - 1]) {
                    return false;
                }
            }
        }

        return true;
    }
}
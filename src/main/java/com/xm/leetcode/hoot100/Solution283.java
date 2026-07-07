package com.xm.leetcode.hoot100;

class Solution283 {
    public void moveZeroes(int[] nums) {
        int pos = 0; // pos 标识已经移动的数字的下标指针
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pos++] = nums[i];
            }
        }
        while (pos < nums.length) {
            nums[pos++] = 0;
        }
    }
}
package com.xm.leetcode.hot100.doublepointer;

import java.util.Arrays;

class Solution283 {
    public void moveZeroes(int[] nums) {
        int j = 0;
        // 左指针 j 寻找第一个0，右指针 i 寻找第一个非0数
        for (int i = 0; i < nums.length; i ++ ) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j ++ ;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        int size = 0;
        for (int x : nums) {
            if (x != 0) {
                nums[size ++ ] = x;
            }
        }
        Arrays.fill(nums, size, nums.length, 0);
    }

    public void moveZeroes3(int[] nums) {
        int count = 0; // 统计前方有多少个0
        for (int i = 0; i < nums.length; i ++ ) {
            if (nums[i] == 0) count ++ ;
            else if (count > 0) {
                nums[i - count] = nums[i];
                nums[i] = 0;
            }
        }
    }
}
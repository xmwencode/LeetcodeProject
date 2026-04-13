package com.xm.leetcode.hot100.array;

class Solution41 {
    public int firstMissingPositive(int[] nums) {
        // 通过算法，将 nums[i] 位置上的数字转换为 i + 1
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                // 交换第 i 位与第 nums[i] - 1 位
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i ++ ) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
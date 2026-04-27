package com.xm.leetcode.hot100.others;

class Solution31 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // 1. 从右到左寻找第一个小于右侧相邻数字的数 nums[i]
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;

        // 如果找到了，执行以下逻辑
        if (i >= 0) {
            // 2. 从右向左找到 nums[i] 右边最小的大于 nums[i] 的数 nums[j]
            int j = n - 1;
            while (nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }

        // 翻转 [i + 1, n - 1]
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }
}
package com.xm.leetcode.hot100.array;

class Solution189 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    // 翻转 [l, r] 内元素数据
    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            // 交换 num[i] <-> num[]
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }

}
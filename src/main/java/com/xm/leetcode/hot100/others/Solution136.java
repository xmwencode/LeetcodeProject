package com.xm.leetcode.hot100.others;

class Solution136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            // 两个相同的数异或都为 0
            // 任何数与 0 异或都不变
            res ^= num;
        }
        return res;
    }
}
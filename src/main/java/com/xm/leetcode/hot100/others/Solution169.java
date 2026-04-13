package com.xm.leetcode.hot100.others;

class Solution169 {
    public int majorityElement(int[] nums) {
        // res 记录当前元素
        int res = 0;
        // count 记录当前元素当前剩余的次数
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
                count++;
            } else if (res == num) count++;
            else count--;
        }
        return res;
    }
}
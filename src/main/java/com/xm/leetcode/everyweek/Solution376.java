package com.xm.leetcode.everyweek;

class Solution376 {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;
        // 当前差值
        int curDiff = 0;
        // 上一个差值
        int preDiff = 0;
        // 记录子数组长度
        int res = 1;
        for (int i = 1; i < n; i++) {
            // 得到当前差值
            curDiff = nums[i] - nums[i - 1];
            // 当前是上升转折点或下降转折点
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                res++;
                preDiff = curDiff;
            }
        }
        return res;
    }
}
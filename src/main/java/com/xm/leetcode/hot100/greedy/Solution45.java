package com.xm.leetcode.hot100.greedy;

class Solution45 {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] steps = new int[n];
        int level = 0;
        for (int i = 0; i < n - 1; i++) {
            // 更新下一层台阶的最大值
            steps[level + 1] = Math.max(steps[level + 1], i + nums[i]);
            if (i == steps[level]) level++;
        }
        return level;
    }
}
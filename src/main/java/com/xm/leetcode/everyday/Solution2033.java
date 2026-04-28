package com.xm.leetcode.everyday;

import java.util.Arrays;

class Solution2033 {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length * grid[0].length;
        int res = 0;
        int index = 0;
        int[] nums = new int[n];
        int target = grid[0][0] % x;

        // 判断是否无解
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] % x != target) {
                    return -1;
                }
                nums[index++] = grid[i][j];
            }
        }

        Arrays.sort(nums);
        // 中位数
        int mid = nums[n / 2];
        for (int i = 0; i < n; i++) {
            res += Math.abs(nums[i] - mid) / x;
        }
        return res;
    }
}
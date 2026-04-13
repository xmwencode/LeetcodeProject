package com.xm.leetcode.hot100.matrix;

class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        // 从 x = m[0, m] 开始查询
        // 如果 target < x 则排除 x 正下方的一列
        // 如果 target > x 则排除 x 正左方的一行
        int i = 0, j = m - 1;
        while (i < n && j >= 0) {
            int x = matrix[i][j];
            if (target < x) {
                j -- ;
                continue;
            } else if (target > x) {
                i ++ ;
                continue;
            } else {
                return true;
            }
        }
        return false;
    }
}
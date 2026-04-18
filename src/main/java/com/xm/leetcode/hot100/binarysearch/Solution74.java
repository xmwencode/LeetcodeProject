package com.xm.leetcode.hot100.binarysearch;

class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int i = 0, j = m - 1;
        // 从第一行最后一个位置开始搜索
        while (i < n && j >= 0) {
            if (target > matrix[i][j]) i++;
            else if (target < matrix[i][j]) j--;
            else return true;
        }
        return false;
    }
}
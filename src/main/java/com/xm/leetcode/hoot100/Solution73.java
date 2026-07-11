package com.xm.leetcode.hoot100;

import java.util.Arrays;

class Solution73 {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        // 记录第一行是否有 0
        boolean firstRowZero = false;
        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }
        // 用 第一行/列 来记录 当前行/列 是否存在 0
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        // 将 [1 ~ n-1][1 ~ m-1] 填充 0
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 将第一列填充 0
        if (matrix[0][0] == 0) {
            for (int[] row : matrix) {
                row[0] = 0;
            }
        }
        // 将第一行填充 0
        if (firstRowZero) {
            Arrays.fill(matrix[0], 0);
        }
    }
}
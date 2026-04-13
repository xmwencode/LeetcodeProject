package com.xm.leetcode.hot100.matrix;

import java.util.Arrays;

class Solution73 {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        // 记录第一行是否有 0
        boolean firstRowHasZero = false;
        for (int x : matrix[0]) {
            if (x == 0) {
                firstRowHasZero = true;
                break;
            }
        }
        // 用第一行的 matrix[0][i] 来保存 第 i 列是否有 0
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j ++ ) {
                if (matrix[i][j] == 0) matrix[i][0] = matrix[0][j] = 0;
            }
        }
        // 如果第 i 行或者第 j 列有 0，那么将该行该列全部变为 0
        for (int i = 1; i < n; i ++ ) {
            for (int j = 1; j < m; j ++ ) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 遍历第一列
        if (matrix[0][0] == 0) {
            for (int[] row : matrix) {
                row[0] = 0;
            }
        }
        if (firstRowHasZero) {
            Arrays.fill(matrix[0], 0);
        }
    }
}
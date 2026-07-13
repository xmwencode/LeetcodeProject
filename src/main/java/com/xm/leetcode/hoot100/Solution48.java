package com.xm.leetcode.hoot100;

class Solution48 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 矩阵转置
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 左右翻转
        for (int i = 0; i < n; i ++ ) {
            for (int j = 0; j < n / 2; j ++ ) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }

    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                // 找到旋转的四个点
                int x1 = i, y1 = j;
                int x2 = j, y2 = n - i - 1;
                int x3 = n - i - 1, y3 = n - j - 1;
                int x4 = n - j - 1, y4 = i;
                // 四个点进行旋转
                int temp = matrix[x1][y1];
                matrix[x1][y1] = matrix[x4][y4];
                matrix[x4][y4] = matrix[x3][y3];
                matrix[x3][y3] = matrix[x2][y2];
                matrix[x2][y2] = temp;
            }
        }
    }
}
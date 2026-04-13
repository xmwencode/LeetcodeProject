package com.xm.leetcode.hot100.matrix;

class Solution48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 对于任意一个坐标 [x, y] 对应的旋转点为: [y, n - x - 1]
        // 按层级由外到内进行旋转，同时旋转 4 个点
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int x = i, y = j;
                // 保存原始值
                int prev = matrix[x][y];
                for (int k = 0; k < 4; k++) {
                    int nx = y;
                    int ny = n - x - 1;
                    int temp = matrix[nx][ny];
                    matrix[nx][ny] = prev;
                    prev = temp;
                    x = nx;
                    y = ny;
                }
            }
        }
    }
}
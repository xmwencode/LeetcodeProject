package com.xm.leetcode.hot100.matrix;

import java.util.ArrayList;
import java.util.List;

class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dir = 0; // 方向
        int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] st = new boolean[n][m];
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (res.size() != n * m) {
            res.add(matrix[i][j]);
            st[i][j] = true;
            // 计算下一个位置
            int tx = i + DIRS[dir][0], ty = j + DIRS[dir][1];
            if (tx < 0 || tx >= n || ty < 0 || ty >= m || st[tx][ty]) {
                dir = (dir + 1) % 4; // 切换方向
            }
            i += DIRS[dir][0];
            j += DIRS[dir][1];
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(new Solution54().spiralOrder(matrix));
    }
}
package com.xm.leetcode.hoot100;

import java.util.ArrayList;
import java.util.List;

class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int[][] DIRT = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] st = new boolean[n][m];
        int dir = 0;
        int i = 0, j = 0;
        while (ans.size() != n * m) {
            ans.add(matrix[i][j]);
            st[i][j] = true;
            int tx = i + DIRT[dir][0], ty = j + DIRT[dir][1];
            if (tx < 0 || ty < 0 || tx >= n || ty >= m || st[tx][ty]) {
                dir = (dir + 1) % 4;
            }
            i += DIRT[dir][0];
            j += DIRT[dir][1];
        }
        return ans;
    }
}
package com.xm.leetcode.everyday;

import java.util.Arrays;

class Solution3742 {
    public int maxPathScore(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        // dp[i, j, k]: 从 [i,j] 开始走，花费为 k 的最大得分
        int[][][] dp = new int[n][m][k + 1];
        for(int[][] a: dp) {
            for(int[] b: a) {
                Arrays.fill(b, -1);
            }
        }
        int res = dfs(n - 1, m - 1, k, dp, grid);
        return res < 0 ? -1 : res;
    }

    /**
     * 到达 (x, y) 位置，花费不超过 k
     */
    private static int dfs(int x, int y, int k, int[][][] dp, int[][] grid) {
        // 如果越界或者超出花费
        if (x < 0 || y < 0 || k < 0) {
            return Integer.MIN_VALUE;
        }
        if (x == 0 && y == 0) {
            return 0;
        }
        // 当前位置已经计算过
        if (dp[x][y][k] != -1) {
            return dp[x][y][k];
        }
        // 当前位置的权重
        int w = grid[x][y];
        // 当前位置的花费
        int cost = grid[x][y] > 0 ? 1 : 0;
        int res = Math.max(
                dfs(x - 1, y, k - cost, dp, grid),
                dfs(x, y - 1, k - cost, dp, grid)
        ) + w;
        dp[x][y][k] = res;
        return res;
    }
}
package com.xm.leetcode.everyday;

import java.util.Arrays;

class Solution3742 {

    public int maxPathScore(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        // 采用 1-based 坐标（i从1~n，j从1~m），避免边界判断
        // dp[i][j][l]：表示走到 1-based 坐标 (i,j)，路径中恰好有 l 个正数的最大路径得分
        // 维度：k+2 是为了防止数组索引越界，覆盖所有合法状态
        int[][][] dp = new int[n + 1][m + 1][k + 2];

        // 求最大路径和，所有状态初始化为 整数最小值（代表该状态不可达）
        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, Integer.MIN_VALUE);
            }
        }
        Arrays.fill(dp[0][1], 1, k + 2, 0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int w = grid[i][j];
                for (int l = 0; l <= k; l++) {
                    int cost = w > 0 ? 1 : 0;
                    dp[i + 1][j + 1][l + 1] = Math.max(
                            dp[i][j + 1][l - cost + 1],
                            dp[i + 1][j][l - cost + 1]
                    ) + w;
                }
            }
        }
        int res = dp[n][m][k + 1];
        return res < 0 ? -1 : res;
    }

    public int maxPathScore1(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        // dp[i, j, k]: 从 [i,j] 开始走，花费为 k 的最大得分
        int[][][] dp = new int[n][m][k + 1];
        for (int[][] a : dp) {
            for (int[] b : a) {
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
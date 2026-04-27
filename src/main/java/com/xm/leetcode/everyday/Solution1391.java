package com.xm.leetcode.everyday;

/**
 * 1 表示连接左单元格和右单元格的街道。
 * 2 表示连接上单元格和下单元格的街道。
 * 3 表示连接左单元格和下单元格的街道。
 * 4 表示连接右单元格和下单元格的街道。
 * 5 表示连接左单元格和上单元格的街道。
 * 6 表示连接右单元格和上单元格的街道。
 */
class Solution1391 {

    private static final int[][][] DIRS = {
            {},
            {{0, -1}, {0, 1}},  // 站在街道 1，可以往左或者往右
            {{-1, 0}, {1, 0}},  // 站在街道 2，可以往上或者往下
            {{0, -1}, {1, 0}},  // 站在街道 3，可以往左或者往下
            {{0, 1}, {1, 0}},   // 站在街道 4，可以往右或者往下
            {{0, -1}, {-1, 0}}, // 站在街道 5，可以往左或者往上
            {{0, 1}, {-1, 0}},  // 站在街道 6，可以往右或者往上
    };

    public boolean hasValidPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        return dfs(0, 0, grid, visited);
    }

    private boolean dfs(int x, int y, int[][] grid, boolean[][] visited) {
        int n = grid.length;
        int m = grid[0].length;
        if (x == n - 1 && y == m - 1) {
            return true;
        }
        visited[x][y] = true;
        int index = grid[x][y];
        for (int[] d : DIRS[index]) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (visited[nx][ny]) continue;
            // 判断右边能否接收当前位置
            int nextIndex = grid[nx][ny];
            if (!canArrive(nextIndex, -d[0], -d[1])) continue;
            if (dfs(nx, ny, grid, visited)) return true;
        }
        return false;
    }

    /**
     * @param nextIndex 目标方向的字典下标
     * @param dx        逆向方向
     * @param dy        逆向方向
     * @return 如果逆向方向在目标方向的两个方向中，那么就能够到达
     */
    private boolean canArrive(int nextIndex, int dx, int dy) {
        int[][] dir = DIRS[nextIndex];
        return (dir[0][0] == dx && dir[0][1] == dy) ||
                (dir[1][0] == dx && dir[1][1] == dy);
    }

}
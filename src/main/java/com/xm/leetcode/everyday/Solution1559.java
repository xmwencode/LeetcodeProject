package com.xm.leetcode.everyday;

class Solution1559 {
    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && dfs(i, j, -1, -1, n, m, grid, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param x       当前位置 x 坐标
     * @param y       当前位置 y 坐标
     * @param px      上一个位置 x 坐标
     * @param py      上一个位置 y 坐标
     * @param grid    原图
     * @param visited 访问标记
     * @return 能否构成环路
     */
    private boolean dfs(int x, int y, int px, int py, int n, int m, char[][] grid, boolean[][] visited) {
        // 标记当前点已访问
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 不能是只有两个点构成
            if (nx == px && ny == py) continue;
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if (grid[nx][ny] != grid[x][y]) continue;
            if (visited[nx][ny] || dfs(nx, ny, x, y, n, m, grid, visited)) {
                return true;
            }
        }
        return false;
    }

    private static final int[] dx = new int[]{-1, 0, 1, 0};
    private static final int[] dy = new int[]{0, -1, 0, 1};
}
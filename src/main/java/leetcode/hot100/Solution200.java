package leetcode.hot100;

class Solution200 {

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, n, m, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int n, int m, int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        dfs(grid, n, m, i + 1, j);
        dfs(grid, n, m, i, j + 1);
        dfs(grid, n, m, i - 1, j);
        dfs(grid, n, m, i, j - 1);
    }
}

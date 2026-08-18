package leetcode.hot100;

class Solution79 {

    private int[] dx = new int[]{0, 1, 0, -1};
    private int[] dy = new int[]{1, 0, -1, 0};

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] st = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    st[i][j] = true;
                    if (dfs(board, st, i, j, 1, word)) return true;
                    st[i][j] = false;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param board 棋盘
     * @param st    状态
     * @param x     x 坐标
     * @param y     y 坐标
     * @param u     下一个待匹配的下表
     * @param word  单词
     * @return 能否匹配成功
     */
    private boolean dfs(char[][] board, boolean[][] st, int x, int y, int u, String word) {
        if (u >= word.length()) return true;
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m || st[nx][ny]) continue;
            if (board[nx][ny] != word.charAt(u)) continue;
            st[x][y] = true;
            if (dfs(board, st, nx, ny, u + 1, word)) return true;
            st[x][y] = false;
        }
        return false;
    }
}
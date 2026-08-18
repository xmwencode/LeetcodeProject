package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

class Solution51 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        boolean[] cols = new boolean[n];
        boolean[] dg = new boolean[n * 2 + 1];
        boolean[] udg = new boolean[n * 2 + 1];

        dfs(n, 0, cols, dg, udg, board, res);
        return res;
    }

    /**
     * @param n     一共的皇后数
     * @param u     当前应该摆放第 u 个皇后
     * @param cols  第 i 列的使用情况
     * @param dg    正斜线上皇后的存在情况
     * @param udg   反斜线上皇后的存在情况
     * @param board 棋盘上棋子摆放的状态
     * @param res   最终的结果列表
     */
    private void dfs(int n, int u, boolean[] cols, boolean[] dg, boolean[] udg,
                     char[][] board, List<List<String>> res) {
        if (u >= n) {
            List<String> list = new ArrayList<>();
            for (char[] chars : board) {
                list.add(new String(chars));
            }
            res.add(list);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (cols[i] || dg[i + u] || udg[n + i - u]) continue;
            cols[i] = true;
            dg[i + u] = true;
            udg[n + i - u] = true;
            board[u][i] = 'Q';
            dfs(n, u + 1, cols, dg, udg, board, res);
            cols[i] = false;
            dg[i + u] = false;
            udg[n + i - u] = false;
            board[u][i] = '.';
        }

    }
}
package com.xm.leetcode.hot100.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution51 {

    public List<List<String>> solveNQueens(int n) {
        // 初始化 board 全部为 '.'
        List<char[]> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // 每行创建新数组，填充 '.'
            char[] row = new char[n];
            Arrays.fill(row, '.');
            board.add(row);
        }
        // 记录全部的棋盘
        List<List<String>> res = new ArrayList<>();
        // 记录当前列否放置了棋子
        boolean[] st = new boolean[n];
        // 记录左下斜线上是否放置了棋子
        boolean[] dg = new boolean[2 * n];
        // 记录右下斜线上是否放置了棋子
        boolean[] udg = new boolean[2 * n];
        dfs(0, n, st, dg, udg, board, res);
        return res;
    }

    /**
     * @param index 当前访问到的棋盘行下标
     * @param n     棋盘行数
     * @param st    当前列否放置了棋子
     * @param dg    左下斜线上是否放置了棋子
     * @param udg   右下斜线上是否放置了棋子
     * @param board 目前完成放置的棋盘
     * @param res   符合条件的所有棋盘
     */
    private void dfs(int index, int n, boolean[] st, boolean[] dg, boolean[] udg, List<char[]> board, List<List<String>> res) {
        if (index >= n) {
            // 记录当前棋盘
            res.add(board.stream().map(String::new).toList());
        }
        // 遍历每一列
        for (int i = 0; i < n; i++) {
            // 当前列/左斜上方/右斜上方 放置了棋子
            if (st[i] || dg[i - index + n] || udg[i + index]) continue;
            // 放置棋子并更新状态
            board.get(index)[i] = 'Q';
            st[i] = udg[i + index] = dg[i - index + n] = true;
            // 递归
            dfs(index + 1, n, st, dg, udg, board, res);
            // 回溯
            board.get(index)[i] = '.';
            st[i] = udg[i + index] = dg[i - index + n] = false;
        }
    }
}
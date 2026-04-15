package com.xm.leetcode.hot100.backtracking;

class Solution79 {
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        char[] words = word.toCharArray();
        // 1. 优化一: 如果 word 中有一个字符出现的数量 > board 中该字符出现的数量，直接返回
        int[] boardCount = new int[128]; // 记录 board 每个字符出现的数量
        int[] wordCount = new int[128]; // 记录 word 每个字符出现的数量
        for (char[] chars : board) {
            for (char c : chars) {
                boardCount[c]++;
            }
        }
        for (char c : words) {
            wordCount[c]++;
            if (wordCount[c] > boardCount[c]) {
                return false;
            }
        }
        // 2. 优化二：如果末尾字符数量少于首字符，翻转字符进行搜索
        if (wordCount[words[words.length - 1]] > wordCount[words[0]]) {
            words = new StringBuilder(word).reverse().toString().toCharArray();
        }
        // 开始搜索
        boolean[][] st = new boolean[n][m];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, words, st, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    int[][] DIRT = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    /**
     * @param board 字符网络
     * @param word  目标单词
     * @param st    搜索记录
     * @param x     当前搜索位置
     * @param y     当前搜索位置
     * @param index 当前搜索到 word 的第 index 位置
     */
    private boolean dfs(char[][] board, char[] word, boolean[][] st, int x, int y, int index) {
        int n = board.length, m = board[0].length;
        // 可以拼接所有字符
        if (index >= word.length) return true;
        // 字符越界/已访问/不匹配 -> 直接返回
        if (x < 0 || x >= n || y < 0 || y >= m || st[x][y] || board[x][y] != word[index]) {
            return false;
        }
        // 标记拼接当前字符
        st[x][y] = true;
        for (int[] dir : DIRT) {
            int tx = x + dir[0], ty = y + dir[1];
            // 可以拼接当前单词, 选择拼接
            if (dfs(board, word, st, tx, ty, index + 1)) {
                return true;
            }
        }
        // 回溯
        st[x][y] = false;
        return false;
    }



    // 未优化：
    public boolean exist1(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        boolean[][] st = new boolean[n][m];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs1(board, word.toCharArray(), st, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param board 字符网络
     * @param word  目标单词
     * @param st    搜索记录
     * @param x     当前搜索位置
     * @param y     当前搜索位置
     * @param index 当前搜索到 word 的第 index 位置
     */
    private boolean dfs1(char[][] board, char[] word, boolean[][] st, int x, int y, int index) {
        int n = board.length, m = board[0].length;
        // 可以拼接所有字符
        if (index >= word.length) return true;
        // 字符越界/已访问/不匹配 -> 直接返回
        if (x < 0 || x >= n || y < 0 || y >= m || st[x][y] || board[x][y] != word[index]) {
            return false;
        }
        // 标记拼接当前字符
        st[x][y] = true;
        for (int[] dir : DIRT) {
            int tx = x + dir[0], ty = y + dir[1];
            // 可以拼接当前单词, 选择拼接
            if (dfs(board, word, st, tx, ty, index + 1)) {
                return true;
            }
        }
        // 回溯
        st[x][y] = false;
        return false;
    }

}
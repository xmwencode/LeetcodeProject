package com.xm.leetcode.hot100.backtracking;

import java.util.LinkedList;
import java.util.List;

class Solution22 {
    public List<String> generateParenthesis(int n) {
        // 从 2n 个位置上选 n 个位置放 '(', n 个位置放 ')'
        // 每个位置可以分为选 '(' 和 ')' 两种情况
        List<String> res = new LinkedList<>();
        StringBuilder path = new StringBuilder();
        dfs(0, 0, n, path, res);
        return res;
    }

    /**
     * @param left  目前枚举的 '(' 个数
     * @param right 目前枚举的 ')' 个数
     * @param n     一共的 '(' 个数
     * @param path  当前生成的括号字符串
     * @param res   全部有效的括号字符串
     */
    private void dfs(int left, int right, int n, StringBuilder path, List<String> res) {
        if (right >= n) {
            // 填完 2n 个括号
            res.add(path.toString());
        }
        if (left < n) {
            // 可以放置 '('
            path.append('(');
            dfs(left + 1, right, n, path, res);
            path.deleteCharAt(path.length() - 1);
        }
        if (right < left) {
            // 可以放置 ')'
            path.append(')');
            dfs(left, right + 1, n, path, res);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
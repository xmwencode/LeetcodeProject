package com.xm.leetcode.hot100.backtracking;

import java.util.ArrayList;
import java.util.List;

class Solution131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(0, 0, s, path, res);
        return res;
    }

    /**
     * 
     * @param index 当前枚举到的 s 的下标
     * @param start 回文字串的开始位置
     * @param s 原字符串
     * @param path 分割的回文字串
     * @param res 全部分割的回文子串集合
     */
    private void dfs(int index, int start, String s, List<String> path, List<List<String>> res) {
        if (index >= s.length()) {
            // 分割完毕
            res.add(new ArrayList<>(path));
            return;
        }
        // 1. 不进行分割
        if (index < s.length() - 1) {
            dfs(index + 1, start, s, path, res);
        }
        // 2. 进行分割: 分割后当前必须是回文字串
        if (isPalindrome(s, start, index)) {
            path.add(s.substring(start, index + 1));
            dfs(index + 1, index + 1, s, path, res);
            path.removeLast();
        }
    }

    /**
     * 时间复杂度：O(n)
     * @return 是否是回文字串
     */
    private boolean isPalindrome(String s, int l, int r) {
        while(l < r) {
            if (s.charAt(l ++ ) != s.charAt(r -- )) {
                return false;
            }
        }
        return true;
    }
}
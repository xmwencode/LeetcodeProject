package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

class Solution131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(0, s, path, res);
        return res;
    }

    /**
     * @param start [start, n) 中是尚未划分的字符串数组
     * @param s     原字符串
     * @param path  [0, start) 中完成分割的字符串数组
     * @param res   全部的分割结果
     */
    private void dfs(int start, String s, List<String> path, List<List<String>> res) {
        if (start >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            // s 中 [start, i] 的位置是回文串，可以在 i 和 i + 1 的位置分割
            if (isPalindrome(s, start, i)) {
                // 分割
                path.add(s.substring(start, i + 1));
                dfs(i + 1, s, path, res);
                path.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
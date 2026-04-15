package com.xm.leetcode.hot100.backtracking;

import java.util.ArrayList;
import java.util.List;

class Solution17 {

    private static final String[] KEY_MAP = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        dfs(digits, 0, path, res);
        return res;
    }

    private void dfs(String digits, int index, StringBuilder path, List<String> res) {
        if (index >= digits.length()) {
            res.add(path.toString());
            return;
        }
        // 获取对应的数字
        int num = digits.charAt(index) - '0';
        // 获取对应的所有字符
        String letters = KEY_MAP[num];
        // 遍历所有字符
        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));
            dfs(digits, index + 1, path, res);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution17().letterCombinations("23"));
    }
}
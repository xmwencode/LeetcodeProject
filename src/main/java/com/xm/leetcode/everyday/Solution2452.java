package com.xm.leetcode.everyday;

import java.util.ArrayList;
import java.util.List;

class Solution2452 {

    // 存储字典树
    int[][] s = new int[10010][26];
    int index = 0;

    // 字典树写法
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        // 存入字典树
        for (String word : dictionary) {
            insert(word.toCharArray());
        }
        List<String> res = new ArrayList<>();
        for (String query : queries) {
            // 深度搜索是否需要两次以内的编辑
            if (dfs(0, query.toCharArray(), 0, 0)) {
                res.add(query);
            }
        }
        return res;
    }

    /**
     * DFS遍历字典树
     *
     * @param p    当前在字典树的节点编号
     * @param word 当前查询的字符数组
     * @param i    当前遍历到单词的第i个字符
     * @param cnt  已经使用的编辑次数
     * @return 是否能在≤2次编辑内匹配字典中的单词
     */
    private boolean dfs(int p, char[] word, int i, int cnt) {
        // 编辑次数超过2，剪枝
        if (cnt > 2) {
            return false;
        }
        // 遍历完成，能够匹配
        if (i == word.length) {
            return true;
        }
        // 当前字典树对应的索引
        int u = word[i] - 'a';
        if (s[p][u] != 0) {
            // 当前字符匹配，不消耗编辑次数
            if (dfs(s[p][u], word, i + 1, cnt)) {
                return true;
            }
        }
        // 字符不匹配，遍历26个字母进行"编辑"
        for (int v = 0; v < 26; v++) {
            // 避免重复编辑
            if (v == u) continue;
            if (s[p][v] != 0) {
                // 字典存在该字符，可以进行编辑
                if (dfs(s[p][v], word, i + 1, cnt + 1)) {
                    return true;
                }
            }
        }
        // 所有情况都不满足
        return false;
    }

    // 字典树插入
    private void insert(char[] word) {
        int p = 0;
        for (char c : word) {
            int u = c - 'a';
            if (s[p][u] == 0) {
                s[p][u] = index++;
            }
            p = s[p][u];
        }
    }


    // 暴力枚举：所有字符串长度相同，所以编辑只有替换操作
    public List<String> twoEditWords2(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList<>();
        for (String q : queries) {
            for (String s : dictionary) {
                int cnt = 0;
                for (int i = 0; i < s.length() && cnt <= 2; i++) {
                    if (s.charAt(i) != q.charAt(i)) {
                        cnt++;
                    }
                }
                if (cnt <= 2) {
                    res.add(q);
                    break;
                }
            }
        }
        return res;
    }
}
package com.xm.leetcode.everyday;

class Solution3093 {

    static class TreeNode {
        TreeNode[] son = new TreeNode[26];
        // 子树中的最短字符串的长度
        int minLen = Integer.MAX_VALUE;
        // 子树中最短字符串的下标
        int minIndex;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        TreeNode root = new TreeNode();
        for (int i = 0; i < wordsContainer.length; i++) {
            char[] s = wordsContainer[i].toCharArray();
            if (s.length < root.minLen) {
                root.minLen = s.length;
                root.minIndex = i;
            }
            // 逆序插入字典树
            TreeNode cur = root;
            for (int j = s.length - 1; j >= 0; j--) {
                int c = s[j] - 'a';
                if (cur.son[c] == null) {
                    cur.son[c] = new TreeNode();
                }
                cur = cur.son[c];
                // 维护 cur 子树中最短字符串的长度及其下标
                // 由于按照 i 从小到大的顺序遍历，字符串长度相同时不更新 minIndex
                if (s.length < cur.minLen) {
                    cur.minLen = s.length;
                    cur.minIndex = i;
                }
            }
        }
        int[] ans = new int[wordsQuery.length];
        // 从查询字符串数组中翻转字符串查询
        for (int i = 0; i < wordsQuery.length; i++) {
            String str = wordsQuery[i];
            TreeNode cur = root;
            // 找到在 query 中最长前缀匹配、在 container 中最短的节点
            for (int j = str.length() - 1; j >= 0; j--) {
                int c = str.charAt(j) - 'a';
                if (cur.son[c] == null) {
                    break;
                }
                cur = cur.son[c];
            }
            ans[i] = cur.minIndex;
        }
        return ans;
    }
}
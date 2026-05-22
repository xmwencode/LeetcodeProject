package com.xm.leetcode.everyday;

class Solution3043 {

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        TrieNode root = new TrieNode();

        // 构建 Trie 树
        for (int num : arr1) {
            insert(root, num);
        }

        int maxLength = 0;
        for (int num : arr2) {
            maxLength = Math.max(maxLength, findPrefix(root, num));
        }

        return maxLength;
    }

    private void insert(TrieNode root, int num) {
        TrieNode node = root;
        String numStr = String.valueOf(num);
        for (char ch : numStr.toCharArray()) {
            int index = ch - '0';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
            node.count++; // 记录通过该节点的数字数量
        }
    }

    private int findPrefix(TrieNode root, int num) {
        TrieNode node = root;
        String numStr = String.valueOf(num);
        int prefixLength = 0;
        for (char ch : numStr.toCharArray()) {
            int index = ch - '0';
            if (node.children[index] == null) {
                break;
            }
            node = node.children[index];
            prefixLength++;
        }
        return prefixLength;
    }

    static class TrieNode {
        TrieNode[] children;
        int count;

        public TrieNode() {
            this.children = new TrieNode[10]; // 数字 0-9
            this.count = 0;
        }
    }
}
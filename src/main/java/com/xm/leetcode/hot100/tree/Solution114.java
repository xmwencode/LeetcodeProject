package com.xm.leetcode.hot100.tree;

import com.xm.utils.TreeNode;

class Solution114 {

    private TreeNode head;

    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = head;
        head = root;
    }

}
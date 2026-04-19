package com.xm.leetcode.hot100.tree;

import com.xm.utils.TreeNode;

class Solution543 {

    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return res;
    }

    private int getDepth(TreeNode root) {
        int l = root.left == null ? 0 : getDepth(root.left);
        int r = root.right == null ? 0 : getDepth(root.right);
        res = Math.max(res, l + r);
        return Math.max(l, r) + 1;
    }
}
package com.xm.leetcode.hot100.tree;

import com.xm.utils.TreeNode;

class Solution98 {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode node, long left, long right) {
        if (node == null) return true;
        int x = node.val;
        return left < x && x < right &&
                isValid(node.left, left, x) &&
                isValid(node.right, x, right);
    }

}
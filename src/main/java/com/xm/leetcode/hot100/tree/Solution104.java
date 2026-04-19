package com.xm.leetcode.hot100.tree;

import com.xm.utils.TreeNode;

class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        // res = max(左边的最大深度, 右边的最大深度) + 1
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
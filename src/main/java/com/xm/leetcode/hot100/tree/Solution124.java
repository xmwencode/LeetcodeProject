package com.xm.leetcode.hot100.tree;

import com.xm.utils.TreeNode;

class Solution124 {

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);
        res = Math.max(res, leftMax + rightMax + root.val);
        return Math.max(Math.max(leftMax, rightMax) + root.val, 0);
    }
}
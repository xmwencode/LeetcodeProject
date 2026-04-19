package com.xm.leetcode.hot100.tree;

import com.xm.utils.TreeNode;

class Solution226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode lNode = invertTree(root.left); // 翻转左子树
        TreeNode rNode = invertTree(root.right); // 翻转右子树
        root.left = rNode;
        root.right = lNode;
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left); // 翻转左子树
        invertTree(root.right); // 翻转右子树
        return root;
    }
}
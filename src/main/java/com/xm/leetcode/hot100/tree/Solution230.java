package com.xm.leetcode.hot100.tree;

import com.xm.utils.TreeNode;

class Solution230 {

    int res;
    int k;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        searchTopK(root);
        return res;
    }

    private void searchTopK(TreeNode currentNode) {
        if (currentNode == null) return;
        // 先检查左子树
        searchTopK(currentNode.left);
        // 再检查当前节点
        k--;
        if (k == 0) res = currentNode.val;
        // 最后检查右子树
        searchTopK(currentNode.right);
    }
}
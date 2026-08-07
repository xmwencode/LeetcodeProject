package leetcode.hot100;

import leetcode.utils.TreeNode;

class Solution114 {

    private TreeNode head;

    public void flatten(TreeNode root) {
        if (root == null) return;
        // 右 - 左 - 根
        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = head; // 头插法
        head = root;
    }
}
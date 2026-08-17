package leetcode.hot100;

import leetcode.utils.TreeNode;

class Solution236 {

    /**
     * 二叉树的最近公共祖先
     *
     * @param root 根节点
     * @param p    子节点 1
     * @param q    子节点 2
     * @return p、q 最近的根节点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (l != null && r != null) return root;
        return l != null ? l : r;
    }

}
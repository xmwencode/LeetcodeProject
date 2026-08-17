package leetcode.hot100;

import leetcode.utils.TreeNode;

class Solution124 {

    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    /**
     * @param root 根节点
     * @return 以 root 为根节点的子树的最大深度
     */
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        res = Math.max(res, left + right + root.val);
        return Math.max(Math.max(left, right) + root.val, 0);
    }
}
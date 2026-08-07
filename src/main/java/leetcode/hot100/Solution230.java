package leetcode.hot100;

import leetcode.utils.TreeNode;

class Solution230 {

    int ans, cnt;

    public int kthSmallest(TreeNode root, int k) {
        cnt = k;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        // 中序遍历
        if (root.left != null) dfs(root.left);
        if (--cnt == 0) ans = root.val;
        if (root.right != null) dfs(root.right);
    }
}
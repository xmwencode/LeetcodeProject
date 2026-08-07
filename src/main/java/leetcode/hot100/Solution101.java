package leetcode.hot100;

import leetcode.utils.TreeNode;

class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        return (t1 != null && t2 != null
                && t1.val == t2.val
                && isSymmetric(t1.left, t2.right)
                && isSymmetric(t1.right, t2.left));
    }
}
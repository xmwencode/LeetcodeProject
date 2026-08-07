package leetcode.hot100;

import leetcode.utils.TreeNode;

class Solution98 {
    public boolean isValidBST(TreeNode root) {
        // 当前子树的上界
        long maxCeil = Long.MAX_VALUE;
        // 当前子树的下界
        long minFloor = Long.MIN_VALUE;
        return isValid(root, minFloor, maxCeil);
    }

    public boolean isValid(TreeNode root, long minFloor, long maxCeil) {
        if (root == null) return true;
        return root.val > minFloor && root.val < maxCeil
                && isValid(root.left, minFloor, root.val)
                && isValid(root.right, root.val, maxCeil);
    }

}
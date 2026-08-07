package leetcode.hot100;

import leetcode.utils.TreeNode;

class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return mergeTrees(nums, 0, nums.length);
    }

    public TreeNode mergeTrees(int[] nums, int l, int r) {
        if (l >= r) return null;
        int mid = (l + r) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = mergeTrees(nums, l, mid);
        root.right = mergeTrees(nums, mid + 1, r);
        return root;
    }

}
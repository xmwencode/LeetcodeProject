package com.xm.leetcode.hot100.tree;

import com.xm.utils.TreeNode;

class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return convertToBST(nums, 0, nums.length);
    }

    public TreeNode convertToBST(int[] nums, int l, int r) {
        if (l == r) return null;
        int mid = l + r >> 1;
        TreeNode left = convertToBST(nums, l, mid);
        TreeNode right = convertToBST(nums, mid + 1, r);
        return new TreeNode(nums[mid], left, right);
    }

}
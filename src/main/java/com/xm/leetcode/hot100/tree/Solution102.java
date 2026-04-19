package com.xm.leetcode.hot100.tree;

import com.xm.utils.TreeNode;

import java.util.*;

class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return List.of();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> vals = new ArrayList<>(n);
            while (n-- > 0) {
                TreeNode node = queue.poll();
                vals.add(node.val);
                if (node.left != null)  queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            ans.add(vals);
        }
        return ans;
    }
}
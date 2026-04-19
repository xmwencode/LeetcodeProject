package com.xm.leetcode.hot100.tree;

import com.xm.utils.TreeNode;

import java.util.*;

class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return List.of();
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        res.add(root.val);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> vals = new ArrayList<>(n);
            while (n-- > 0) {
                TreeNode node = queue.poll();
                vals.add(node.val);
                if (node.left != null)  queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            if (!queue.isEmpty()) {
                // 即返回每层层序遍历的最后一个节点
                TreeNode last = queue.getLast();
                res.add(last.val);
            }
        }
        return res;
    }
}
package com.xm.leetcode.hot100.tree;

import com.xm.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class Solution437 {

    // 记录前缀和
    // 定义：从二叉树的根节点开始，路径和为 pathSum 的路径数量
    Map<Long, Integer> preSumCount = new HashMap<>();

    long pathSum, targetSum;
    int res = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        this.pathSum = 0;
        this.targetSum = targetSum;
        this.preSumCount.put(0L, 1);
        traverse(root);
        return res;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序遍历位置
        pathSum += root.val;
        // 从二叉树的根节点开始，路径和为 pathSum - targetSum 的路径条数
        // 就是路径和为 targetSum 的路径条数
        res += preSumCount.getOrDefault(pathSum - targetSum, 0);
        // 记录从二叉树的根节点开始，路径和为 pathSum 的路径条数
        preSumCount.put(pathSum, preSumCount.getOrDefault(pathSum, 0) + 1);

        traverse(root.left);
        traverse(root.right);

        // 后序遍历位置
        preSumCount.put(pathSum, preSumCount.get(pathSum) - 1);
        pathSum -= root.val;
    }


    public int pathSum2(TreeNode root, int targetSum) {
        if (root == null) return 0;
        int res = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            res += dfs(poll, 0, targetSum);
            if (poll.left != null) queue.offer(poll.left);
            if (poll.right != null) queue.offer(poll.right);
        }
        return res;
    }

    public int dfs(TreeNode root, long curSum, int targetSum) {
        if (root == null) return 0;
        curSum += root.val;
        return (curSum == targetSum ? 1 : 0)
                + dfs(root.left, curSum, targetSum)
                + dfs(root.right, curSum, targetSum);
    }

}
package com.xm.leetcode.hot100.tree;

import com.xm.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


class Solution94 {

    // 栈模拟递归写法
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null) {
            // 不断往左子树走，每走一次就将当前节点保存到栈中
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                // 当前节点出栈，进行回溯
                TreeNode pop = stack.pop();
                // 记录当前元素值
                res.add(pop.val);
                // 搜索右节点
                root = pop.right;
            }
        }
        return res;
    }


    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recursion(root, res);
        return res;
    }

    // 递归写法
    private void recursion(TreeNode root, List<Integer> list) {
        if (root == null) return;
        // 1. 获取左节点
        recursion(root.left, list);
        // 2. 添加自己的节点
        list.add(root.val);
        // 3. 获取右节点
        recursion(root.right, list);
    }


}
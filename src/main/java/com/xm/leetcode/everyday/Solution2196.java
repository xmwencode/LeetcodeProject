package com.xm.leetcode.everyday;

import com.xm.utils.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution2196 {

    public TreeNode createBinaryTree(int[][] descriptions) {
        // 存储每一个元素对应的 父节点值 => 父节点 的映射关系
        Map<Integer, TreeNode> map = new HashMap<>();
        // 记录【只出现一次的数字】就是根节点
        int root = 0;
        for (int[] d : descriptions) {
            int parentVal = d[0];
            int childVal = d[1];
            int isLeft = d[2];
            if (!map.containsKey(parentVal)) {
                map.put(parentVal, new TreeNode(parentVal));
                root ^= parentVal;
            }
            if (!map.containsKey(childVal)) {
                map.put(childVal, new TreeNode(childVal));
                root ^= childVal;
            }
            if (isLeft == 1) {
                map.get(parentVal).left = map.get(childVal);
            } else {
                map.get(parentVal).right = map.get(childVal);
            }
            root ^= childVal;
        }
        return map.get(root);
    }

    public TreeNode createBinaryTree2(int[][] descriptions) {
        // 存储每一个元素对应的 父节点值 => 父节点 的映射关系
        Map<Integer, TreeNode> map = new HashMap<>();
        // 记录有父节点的值
        Set<Integer> set = new HashSet<>();
        for (int[] d : descriptions) {
            int parentVal = d[0];
            int childVal = d[1];
            int isLeft = d[2];
            // 取出/创建父节点
            TreeNode parent = map.computeIfAbsent(parentVal, TreeNode::new);
            // 取出/创建子节点
            TreeNode child = map.computeIfAbsent(childVal, TreeNode::new);
            if (isLeft == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            set.add(childVal);
        }
        // 寻找在 map 中没有在 set 中出现过的值就是根节点
        Integer ans = map.keySet().stream().filter(x -> !set.contains(x)).toList().getFirst();
        return map.get(ans);
    }
}
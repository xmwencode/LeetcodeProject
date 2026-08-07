package leetcode.hot100;

import leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        if (root.left != null) res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        if (root.right != null) res.addAll(inorderTraversal(root.right));
        return res;
    }
}
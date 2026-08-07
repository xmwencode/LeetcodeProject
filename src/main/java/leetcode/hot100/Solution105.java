package leetcode.hot100;

import leetcode.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

class Solution105 {

    int[] preorder;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        // 以前序遍历中的点为分界点，对中序遍历节点进行分界
        for (int i = 0; i < inorder.length; i++) {
            // 这样就能通过 map.get(preorder[i]) 来查询该点在 inorder 中的位置
            map.put(inorder[i], i);
        }
        return merge(0, 0, preorder.length - 1);
    }

    /**
     *
     * @param root 当前根节点在 preorder 中的下标
     * @param l    preorder[root] 在 inorder 中分界后的左界
     * @param r    preorder[root] 在 inorder 中分界后的右界
     * @return 以该 root 为根节点的树节点
     */
    private TreeNode merge(int root, int l, int r) {
        if (l > r) return null;
        TreeNode node = new TreeNode(preorder[root]);
        // i 为分界点进行分界
        int i = map.get(preorder[root]);
        node.left = merge(root + 1, l, i - 1);
        node.right = merge(root + i - l + 1, i + 1, r);
        return node;
    }
}

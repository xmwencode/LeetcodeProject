package leetcode.hot100;

import leetcode.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

class Solution437 {

    /**
     * 从根节点开始，路径和为 pathSum 的路径的个数
     * key: pathSum
     * value: count
     */
    Map<Long, Integer> map = new HashMap<>();
    int res = 0;

    public int pathSum(TreeNode root, int targetSum) {
        map.put(0L, 1);
        dfs(root, 0, targetSum);
        return res;
    }

    /**
     * 进行前序遍历
     * 参考 {@link Solution560}
     *
     * @param root      当前遍历到的 "根节点"
     * @param pathSum   到达当前节点的路径和（不包括当前节点）
     * @param targetSum 目标和
     */
    private void dfs(TreeNode root, long pathSum, int targetSum) {
        if (root == null) return;
        pathSum += root.val;
        res += map.getOrDefault(pathSum - targetSum, 0);
        map.merge(pathSum, 1, Integer::sum);
        dfs(root.left, pathSum, targetSum);
        dfs(root.right, pathSum, targetSum);
        map.merge(pathSum, -1, Integer::sum);
    }
}
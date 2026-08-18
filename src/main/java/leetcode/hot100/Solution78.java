package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        // 记录全部组合
        List<List<Integer>> res = new ArrayList<>();
        // 记录当前组合
        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, path, res);
        return res;
    }

    private void dfs(int[] nums, int u, List<Integer> path,
                     List<List<Integer>> res) {
        if (u >= nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 选择该元素
        path.add(nums[u]);
        dfs(nums, u + 1, path, res);
        // 不选择该元素
        path.remove(path.size() - 1);
        dfs(nums, u + 1, path, res);
    }
}
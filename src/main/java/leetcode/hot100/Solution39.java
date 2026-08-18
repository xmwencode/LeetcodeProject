package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(candidates, 0, 0, target, path, res);
        return res;
    }

    private void dfs(int[] nums, int u, int sum, int target, List<Integer> path, List<List<Integer>> res) {
        if (sum > target) return;
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = u; i < nums.length; i++) {
            // 每个数都可以重复选
            path.add(nums[i]);
            dfs(nums, i, sum + nums[i], target, path, res);
            path.remove(path.size() - 1);
        }
    }
}
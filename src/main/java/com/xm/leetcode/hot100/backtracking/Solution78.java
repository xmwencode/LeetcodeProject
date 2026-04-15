package com.xm.leetcode.hot100.backtracking;

import java.util.ArrayList;
import java.util.List;

class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, path, res);
        return res;
    }

    private void dfs(int[] nums, int u, List<Integer> path, List<List<Integer>> res) {
        if (u >= nums.length) {
            // 存入子集中
            res.add(new ArrayList<>(path));
            return;
        }
        // 1. 选当前数
        path.add(nums[u]);
        dfs(nums, u + 1, path, res);
        path.remove(path.size() - 1);
        // 2. 不选当前数
        dfs(nums, u + 1, path, res);
    }
}
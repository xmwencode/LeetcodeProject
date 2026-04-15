package com.xm.leetcode.hot100.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        dfs(candidates, 0, 0, target, path, res);
        return res;
    }

    private void dfs(int[] nums, int index, int sum, int target, LinkedList<Integer> path, List<List<Integer>> res) {
        if (sum > target) return;
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 每一个数都可以被重复选
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i, sum + nums[i], target, path, res);
            path.removeLast();
        }
    }
}
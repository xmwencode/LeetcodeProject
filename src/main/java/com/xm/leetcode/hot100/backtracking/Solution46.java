package com.xm.leetcode.hot100.backtracking;

import java.util.ArrayList;
import java.util.List;

class Solution46 {


    public List<List<Integer>> permute(int[] nums) {
        // 记录全排列结果
        List<List<Integer>> res = new ArrayList<>();
        // 记录使用状态
        boolean[] st = new boolean[nums.length];
        // 记录当前排列
        List<Integer> path = new ArrayList<>();
        // 从 nums[0] 开始递归
        dfs(nums, path, st, res);
        return res;
    }

    private void dfs(int[] nums, List<Integer> path, boolean[] st, List<List<Integer>> res) {
        if (path.size() >= nums.length) {
            // 存入全排列
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!st[i]) {
                st[i] = true;
                path.add(nums[i]);
                dfs(nums, path, st, res);
                st[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
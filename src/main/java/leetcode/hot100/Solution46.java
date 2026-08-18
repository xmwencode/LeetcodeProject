package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        // 记录全排列
        List<List<Integer>> res = new ArrayList<>();
        // 记录当前排列
        List<Integer> path = new ArrayList<>();
        // 记录当前数字使用状态
        boolean[] st = new boolean[nums.length];
        dfs(nums, 0, st, path, res);
        return res;
    }

    private void dfs(int[] nums, int u, boolean[] st,
                     List<Integer> path, List<List<Integer>> res) {
        int n = nums.length;
        if (u >= n) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!st[i]) {
                path.add(nums[i]);
                st[i] = true;
                dfs(nums, u + 1, st, path, res);
                path.remove(path.size() - 1);
                st[i] = false;
            }
        }
    }
}
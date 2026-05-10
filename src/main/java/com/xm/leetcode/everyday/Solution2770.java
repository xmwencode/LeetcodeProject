package com.xm.leetcode.everyday;

import java.util.*;

class Solution2770 {

    private int ans = -1;


    /**
     * 动态规划
     */
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        // dp[i]: 到达位置 i 的最大步数
        int[] dp = new int[n];
        // 初始化为不可达
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == -1) continue;
            // 更新能到达的所有位置
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(nums[i] - nums[j]) <= target) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        if (dp[n - 1] == -1) return -1;
        return dp[n - 1];
    }

    /**
     * dfs 超时
     */
    public int maximumJumps1(int[] nums, int target) {
        // 预处理当前节点可以到达的节点
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(nums[i] - nums[j]) <= target) {
                    map.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                }
            }
        }
        vis[0] = true;
        dfs(0, 0, n, map, vis);
        return ans > 0 ? ans : -1;
    }

    private void dfs(int u, int cnt, int n, Map<Integer, List<Integer>> map, boolean[] vis) {
        if (u == n - 1) {
            ans = Math.max(cnt, ans);
            return;
        }
        List<Integer> nextList = map.getOrDefault(u, new ArrayList<>());
        for (Integer next : nextList) {
            if (!vis[next]) {
                vis[next] = true;
                dfs(next, cnt + 1, n, map, vis);
                vis[next] = false;
            }
        }
    }
}
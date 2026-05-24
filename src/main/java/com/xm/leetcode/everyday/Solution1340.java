package com.xm.leetcode.everyday;

class Solution1340 {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        // 记忆化数组，计算从 i 开始跳能访问的最多下标数量
        int[] cnt = new int[n];
        // 枚举起点
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(i, d, arr, cnt));
        }
        return ans;
    }

    private int dfs(int i, int d, int[] arr, int[] cnt) {
        // 之前计算过
        if (cnt[i] > 0) return cnt[i];
        int res = 1;
        // 向左跳
        for (int j = i - 1; j >= Math.max(i - d, 0) && arr[i] > arr[j]; j--) {
            res = Math.max(res, dfs(j, d, arr, cnt) + 1);
        }
        // 向右跳
        for (int j = i + 1; j <= Math.min(i + d, arr.length - 1) && arr[i] > arr[j]; j++) {
            res = Math.max(res, dfs(j, d, arr, cnt) + 1);
        }
        cnt[i] = res;
        return res;
    }
}
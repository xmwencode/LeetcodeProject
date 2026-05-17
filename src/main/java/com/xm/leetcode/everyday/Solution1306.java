package com.xm.leetcode.everyday;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution1306 {
    public boolean canReachBfs(int[] arr, int start) {
        int n = arr.length;
        boolean[] vis = new boolean[n];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        vis[start] = true;
        while (!queue.isEmpty()) {
            int i = queue.poll();
            if (arr[i] == 0) return true;
            // 跳到 i + arr[i]
            int next = i + arr[i];
            if (next >= 0 && next < n && !vis[next]) {
                vis[next] = true;
                queue.add(next);
            }
            // 跳到 i - arr[i]
            next = i - arr[i];
            if (next >= 0 && next < n && !vis[next]) {
                vis[next] = true;
                queue.add(next);
            }
        }
        return false;
    }

    public boolean canReachDfs(int[] arr, int start) {
        int n = arr.length;
        boolean[] vis = new boolean[n];
        return dfs(arr, start, vis);
    }

    private boolean dfs(int[] arr, int i, boolean[] vis) {
        if (i < 0 || i >= arr.length || vis[i]) return false;
        if (arr[i] == 0) return true;
        vis[i] = true;
        return dfs(arr, i + arr[i], vis) | dfs(arr, i - arr[i], vis);
    }

}
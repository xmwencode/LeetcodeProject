package com.xm.leetcode.everyday;

import java.util.*;

class Solution1345 {
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] vis = new boolean[n];
        queue.add(0);
        vis[0] = true;

        for (int res = 0; ; res++) {
            Deque<Integer> q = queue;
            queue = new ArrayDeque<>();
            while(!q.isEmpty()) {
                int i = q.poll();
                if (i == n - 1) {
                    return res;
                }
                // 跳到 i + 1
                int next = i + 1;
                if (next >= 0 && next < n && !vis[next]) {
                    queue.add(next);
                    vis[next] = true;
                }
                // 跳到 i - 1
                next = i - 1;
                if (next >= 0 && next < n && !vis[next]) {
                    queue.add(next);
                    vis[next] = true;
                }
                int x = arr[i];
                List<Integer> list = map.getOrDefault(x, Collections.emptyList());
                for (Integer ne : list) {
                    if (ne != i && !vis[ne]) {
                        queue.add(ne);
                        vis[ne] = true;
                    }
                }
                // 关键：一定要删除访问过的点，减少哈希表查询次数
                map.remove(x);
            }
        }
    }
}
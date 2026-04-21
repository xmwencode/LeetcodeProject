package com.xm.leetcode.everyday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution1722 {

    private int[] fa;

    private int find(int x) {
        if (fa[x] == x) return x;
        return fa[x] = find(fa[x]);
    }

    private void add(int x, int y) {
        x = find(x);
        y = find(y);
        if (x <= y) fa[y] = x;
        else fa[x] = y;
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        fa = new int[n];
        // 初始化并查集
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
        // 合并所有可交换的位置，建立连通块
        for (int[] x : allowedSwaps) {
            add(x[0], x[1]);
        }
        // 核心：map[根节点] = 该连通块内 source 数字的频次
        Map<Integer, Integer>[] countMap = new HashMap[n];
        for (int i = 0; i < n; i++) {
            int root = find(i);
            // 根节点的map初始化一次即可
            if (countMap[root] == null) countMap[root] = new HashMap<>();
            // 统计当前位置source数字的频次
            countMap[root].put(source[i], countMap[root].getOrDefault(source[i], 0) + 1);
        }
        // 统计能匹配的数字数量
        int match = 0;
        for (int i = 0; i < n; i++) {
            int root = find(i);
            int num = target[i];
            // 如果当前连通块有这个数字，就匹配成功
            if (countMap[root].getOrDefault(num, 0) > 0) {
                countMap[root].put(num, countMap[root].get(num) - 1);
                match++;
            }
        }
        // 总长度 - 匹配数 = 最小汉明距离
        return n - match;
    }

    public int minimumHammingDistance2(int[] source, int[] target, int[][] allowedSwaps) {
        // 题意：将 source 的数字经过最优交换后，与 target 对应位置上的数字不同的最小个数
        // source: [1, 1, 2, 3]  target: [2, 2, 4, 1]
        // source 可以交换成 [2, 1, 3, 1] 与 target 有两个数字不一样，所以最小汉明距离就是 2
        // 把 source 中可以交换的位置作为连通块，寻找 target 对应连通块中中多余的数字
        int n = source.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : allowedSwaps) {
            int i = e[0], j = e[1];
            graph.get(i).add(j);
            graph.get(j).add(i);
        }
        boolean[] vis = new boolean[n];
        int res = 0;
        for (int x = 0; x < n; x++) {
            if (!vis[x]) {
                Map<Integer, Integer> diff = new HashMap<>();
                dfs(x, source, target, graph, vis, diff);
                for (int v : diff.values()) {
                    res += Math.abs(v);
                }
            }
        }
        return res / 2;
    }

    private void dfs(int x, int[] source, int[] target, List<List<Integer>> graph, boolean[] vis, Map<Integer, Integer> diff) {
        vis[x] = true;
        diff.merge(source[x], 1, Integer::sum);
        diff.merge(target[x], -1, Integer::sum);
        for (int y : graph.get(x)) {
            if (!vis[y]) {
                dfs(y, source, target, graph, vis, diff);
            }
        }
    }
}
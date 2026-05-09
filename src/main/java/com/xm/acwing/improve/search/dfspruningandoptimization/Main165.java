package com.xm.acwing.improve.search.dfspruningandoptimization;

import java.util.*;

public class Main165 {

    private static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> w = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            w.add(sc.nextInt());
        }
        // 重量从大到小排序
        w.sort(Collections.reverseOrder());
        List<Integer> list = new ArrayList<>();
        dfs(0, n, m, w, list);
        System.out.println(ans);
    }

    /**
     * @param u    当前遍历到第 u 只小猫
     * @param n    小猫总数
     * @param m    缆车限重
     * @param w    小猫体重
     * @param list 当前的缆车
     */
    private static void dfs(int u, int n, int m, List<Integer> w, List<Integer> list) {
        // 剪枝
        if (list.size() >= ans) return;
        if (u >= n) {
            ans = Math.min(ans, list.size());
            return;
        }
        // 已有缆车中放置小猫
        for (int i = 0; i < list.size(); i++) {
            int curr = list.get(i);
            if (curr + w.get(u) <= m) {
                // 可以放下
                list.set(i, curr + w.get(u));
                dfs(u + 1, n, m, w, list);
                // 回溯
                list.set(i, curr);
            }
        }
        // 新开一个缆车
        list.add(w.get(u));
        dfs(u + 1, n, m, w, list);
        // 回溯
        list.remove(list.size() - 1);
    }
}

package com.xm.acwing.improve.dp.longestascendingsubsequencemodel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main187 {

    static int res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) break;
            // 结果重置
            res = Integer.MAX_VALUE;
            int[] w = new int[n];
            for (int i = 0; i < n; i++) {
                w[i] = sc.nextInt();
            }
            // 需要多少套系统：贪心 =>
            // 1. 当前所有系统都不能拦截，新建系统
            // 2. 如果有一个能拦截的，直接选第一个即可
            // 如果一个序列里只有一个元素，那么可能上升也可能下降
            List<Integer> up = new ArrayList<>();
            List<Integer> down = new ArrayList<>();
            dfs(0, n, w, up, down);
            System.out.println(res);
        }
    }

    /**
     *
     * @param u 当前遍历到第 u 个数
     * @param n 一共有 n 个数
     * @param w 导弹序列
     * @param up 当前的上升序列
     * @param down 当前的下降序列
     */
    private static void dfs(int u, int n, int[] w, List<Integer> up, List<Integer> down) {
        if (u >= n) {
            // 遍历完毕
            res = Math.min(res, up.size() + down.size());
            return;
        }
        if (up.size() + down.size() >= res) {
            // 提前剪枝
            return;
        }
        // 放在上升序列中
        boolean flag = false;
        for (int i = 0; i < up.size(); i++) {
            int end = up.get(i);
            if (end < w[u]) {
                up.set(i, w[u]);
                flag = true;
                // 能放下直接放就行
                dfs(u + 1, n, w, up, down);
                // 回溯
                up.set(i, end);
                break;
            }
        }
        if (!flag) {
            // 不能放下，新开上升序列
            up.add(w[u]);
            dfs(u + 1, n, w, up, down);
            up.remove(up.size() - 1);
        }
        // 放在下降序列中
        flag = false;
        for (int i = 0; i < down.size(); i++) {
            int end = down.get(i);
            if (end > w[u]) {
                down.set(i, w[u]);
                flag = true;
                dfs(u + 1, n, w, up, down);
                down.set(i, end);
                break;
            }
        }
        if (!flag) {
            down.add(w[u]);
            dfs(u + 1, n, w, up, down);
            down.remove(down.size() - 1);
        }
    }

}

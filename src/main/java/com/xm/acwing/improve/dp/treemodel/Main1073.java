package com.xm.acwing.improve.dp.treemodel;

import java.util.Arrays;
import java.util.Scanner;

public class Main1073 {

    private static int N = 20010;
    private static int[] e = new int[N];
    private static int[] ne = new int[N];
    private static int[] w = new int[N];
    private static int[] h = new int[N];
    private static int idx;
    // 表示向下走的最长的路径
    private static int[] downMax = new int[N];
    // 表示当前节点最长子路径的子节点下标
    private static int[] downMaxSon = new int[N];
    // 表示向下走的次长的路径
    private static int[] downSec = new int[N];
    // 表示当前节点次长子路径的子节点下标
    private static int[] downSecSon = new int[N];
    // 表示向上走的最长路径
    private static int[] upMax = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Arrays.fill(h, -1);
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            add(a, b, c);
            add(b, a, c);
        }
        dfs_down(1, -1);
        dfs_up(1, -1);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            res = Math.min(res, Math.max(downMax[i], upMax[i]));
        }
        System.out.println(res);
    }

    /**
     * @param u  当前根节点
     * @param fa 当前节点的父节点
     */
    private static void dfs_up(int u, int fa) {
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (j == fa) continue;
            if (downMaxSon[u] == j) {
                // 当前子节点在父节点的最大路径上，使用次大值更新
                upMax[j] = Math.max(upMax[u], downSec[u]) + w[i];
            } else {
                // 当前子节点不在父节点的最大路径上，使用最大值更新
                upMax[j] = Math.max(upMax[u], downMax[u]) + w[i];
            }
            // 递归更新所有点往上面走的最长路径
            dfs_up(j, u);
        }
    }

    /**
     * @param u  当前根节点
     * @param fa 当前节点的父节点
     */
    private static void dfs_down(int u, int fa) {
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (j == fa) continue;
            // 用当前子节点更新当前节点的最长/次长子树
            dfs_down(j, u);
            int d = downMax[j] + w[i];
            if (d >= downMax[u]) {
                downSec[u] = downMax[u];
                downSecSon[u] = downMaxSon[u];
                downMax[u] = d;
                downMaxSon[u] = j;
            } else if (d > downSec[u]) {
                downSec[u] = d;
                downSecSon[u] = j;
            }
        }
    }

    private static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}

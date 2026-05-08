package com.xm.acwing.improve.dp.treemodel;

import java.util.Arrays;
import java.util.Scanner;

public class Main1075 {

    private static int N = 50010;
    private static int[] e = new int[N];
    private static int[] ne = new int[N];
    private static int[] h = new int[N];
    private static boolean[] vis = new boolean[N];
    private static int[] sum = new int[N];
    private static int idx;
    private static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 预处理每个数的因数之和
        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= n / i; j++) {
                sum[i * j] += i;
            }
        }
        Arrays.fill(h, -1);
        // 在符合 因数之和 < 该数 条件的数之间连一条边
        for (int i = 2; i <= n; i++) {
            if (sum[i] < i) {
                add(sum[i], i);
                vis[i] = true;
            }
        }
        // 标记过的节点才会构成森林
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                dfs(i);
            }
        }
        System.out.println(ans);
    }

    /**
     * @param u 当前根节点
     * @return 以当前节点为根节点的最长子树
     */
    private static int dfs(int u) {
        int max = 0, sec = 0;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            int d = dfs(j) + 1;
            if (d > max) {
                sec = max;
                max = d;
            } else if (d > sec) {
                sec = d;
            }
        }
        ans = Math.max(ans, max + sec);
        return max;
    }

    private static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}

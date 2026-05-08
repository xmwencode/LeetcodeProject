package com.xm.acwing.improve.dp.treemodel;

import java.util.Arrays;
import java.util.Scanner;

public class Main285 {

    private static int N = 6010;
    private static int[] e = new int[N];
    private static int[] ne = new int[N];
    private static int[] h = new int[N];
    private static int[] w = new int[N];
    private static int idx;

    // dp[u, 0] 以 u 为根节点并且不选 u 的最大快乐指数
    // dp[u, 1] 以 u 为根节点并且选 u 的最大快乐指数
    private static int[][] dp = new int[N][2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
        }
        Arrays.fill(h, -1);
        boolean[] st = new boolean[n + 1];
        for (int i = 1; i < n; i++) {
            int l = sc.nextInt();
            int k = sc.nextInt();
            // k 是 l 的上司
            add(k, l);
            st[l] = true;
        }
        int root = 1;
        while (st[root]) {
            root++;
        }
        // 从根节点开始 dp
        dfs(root);
        int res = Math.max(dp[root][0], dp[root][1]);
        System.out.println(res);
    }

    /**
     * 从以 u 为根的子树中选，得到的最大快乐指数
     */
    private static void dfs(int u) {
        dp[u][0] = 0;
        dp[u][1] = w[u];
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            dfs(j);
            // 如果不选 u 点，则可以选子节点
            dp[u][0] += Math.max(dp[j][0], dp[j][1]);
            // 如果选了 u 点，就不能选子节点
            dp[u][1] += dp[j][0];
        }
    }

    private static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}

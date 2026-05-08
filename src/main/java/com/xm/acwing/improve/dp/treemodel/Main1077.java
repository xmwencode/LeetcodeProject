package com.xm.acwing.improve.dp.treemodel;

import java.util.Arrays;
import java.util.Scanner;

public class Main1077 {

    private static int N = 3010;
    private static int[] h = new int[N];
    private static int[] e = new int[N];
    private static int[] w = new int[N];
    private static int[] ne = new int[N];
    private static int idx;

    // dp[u, 0] 该节点能被父节点看到的最小消费
    // dp[u, 1] 该节点能被子节点看到的最小消费
    // dp[u, 2] 在当前节点放置守卫的最小消费
    private static int[][] dp = new int[N][3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] st = new boolean[n + 1];
        Arrays.fill(h, -1);
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            w[a] = sc.nextInt();
            int m = sc.nextInt();
            for (int j = 0; j < m; j++) {
                int b = sc.nextInt();
                st[b] = true;
                add(a, b);
            }
        }
        int root = 1;
        while (st[root]) {
            root++;
        }
        dfs(root);
        System.out.println(Math.min(dp[root][1], dp[root][2]));
    }

    private static void dfs(int u) {
        dp[u][0] = 0;
        dp[u][1] = Integer.MAX_VALUE;
        dp[u][2] = w[u];
        for (int i = h[u]; i != -1; i = ne[i]) {
            int son = e[i];
            dfs(son);
            // u 能被父节点看到，子节点可以不放（能被子节点观察到），可以放（能被自己观察到）
            dp[u][0] += Math.min(dp[son][1], dp[son][2]);
            // u 能放（能被自己观察到），子节可以处于任意状态
            dp[u][2] += Math.min(dp[son][0], Math.min(dp[son][1], dp[son][2]));
        }
        // u 可以被子节点观察到
        for (int i = h[u]; i != -1; i = ne[i]) {
            int son = e[i];
            dp[u][1] = Math.min(dp[u][1],
                    dp[u][0] + dp[son][2] - Math.min(dp[son][1], dp[son][2])
            );
        }

    }

    private static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}

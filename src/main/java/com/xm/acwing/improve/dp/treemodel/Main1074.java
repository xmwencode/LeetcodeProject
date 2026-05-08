package com.xm.acwing.improve.dp.treemodel;

import java.util.Arrays;
import java.util.Scanner;

public class Main1074 {

    private static int N = 210;
    private static int[] h = new int[N];
    private static int[] e = new int[N];
    private static int[] w = new int[N];
    private static int[] ne = new int[N];
    private static int idx;

    // dp[u, k] 以 u 为根节点，保留树枝不超过 k 的最多苹果数量
    private static int[][] dp = new int[N][N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Arrays.fill(h, -1);
        for (int i = 1; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            add(a, b, c);
            add(b, a, c);
        }
        dfs(1, -1, m);
        System.out.println(dp[1][m]);
    }

    private static void dfs(int u, int fa, int m) {
        for (int i = h[u]; i != -1; i = ne[i]) {
            int son = e[i];
            if (son == fa) continue;
            dfs(son, u, m);
            for (int j = m; j >= 0; j--) {
                for (int k = 0; k <= j - 1; k++) {
                    dp[u][j] = Math.max(dp[u][j], dp[u][j - k - 1] + dp[son][k] + w[i]);
                }
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

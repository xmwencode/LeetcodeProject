package com.xm.acwing.improve.dp.backpackmodel;

import java.util.Scanner;

public class Main1013 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // dp[i, j] 前 i 家公司，分配数量不超过 j 台机器的最大盈利
        int[][] dp = new int[n + 1][m + 1];
        // 记录给第 i 家公司分配 j 台机器时的盈利
        int[][] w = new int[n + 1][m + 1];
        // 记录前 i 家公司，分配 j 台机器时，第 i 家公司分配了多少台机器
        int[][] path = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                w[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int k = 1; k <= j; k++) {
                    if (dp[i][j] < dp[i - 1][j - k] + w[i][k]) {
                        dp[i][j] = dp[i - 1][j - k] + w[i][k];
                        path[i][j] = k;
                    }
                }
            }
        }
        System.out.println(dp[n][m]);

        // 路径回溯
        dfs(n, n, m, path);
    }

    /**
     *
     * @param u 当前分配到第几家厂家
     * @param n 一共有几家厂家
     * @param m 剩余的机器数量
     * @param path 记录前 i 家公司，分配 j 台机器时，第 i 家公司分配了多少台机器
     */
    private static void dfs(int u, int n, int m, int[][] path) {
        if (u <= 0) return;
        int count = path[u][m];
        dfs(u - 1, n, m - count, path);
        System.out.println(u + " " + count);
    }
}

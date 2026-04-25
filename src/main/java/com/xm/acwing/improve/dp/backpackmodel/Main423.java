package com.xm.acwing.improve.dp.backpackmodel;

import java.util.Scanner;

public class Main423 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] dp = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            int v = sc.nextInt();
            int w = sc.nextInt();
            for (int j = m; j >= v; j--) {
                dp[j] = Math.max(dp[j], dp[j - v] + w);
            }
        }
        System.out.println(dp[m]);
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        // 物品权重
        int[] w = new int[n + 1];
        // 物品体积
        int[] v = new int[m + 1];
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j ++ ) {
                dp[i][j] = dp[i - 1][j];
                if (j >= v[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v[i]] + w[i]);
                }
            }
        }
        System.out.println(dp[n][m]);
    }

}

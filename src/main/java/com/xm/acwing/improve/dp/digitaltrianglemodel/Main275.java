package com.xm.acwing.improve.dp.digitaltrianglemodel;

import java.util.Scanner;

public class Main275 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] w = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                w[i][j] = sc.nextInt();
            }
        }
        // dp[k, i1, i2]: A 走到 (i1, k-i1) B 走到 (i2, k-i2) 的最大好心程度
        int[][][] dp = new int[m + n + 2][n + 1][n + 1];
        for (int k = 2; k <= n + m; k++) {
            for (int i1 = 1; i1 <= n; i1++) {
                for (int i2 = 1; i2 <= n; i2++) {
                    int j1 = k - i1, j2 = k - i2;
                    if (j1 <= 0 || j1 > m || j2 <= 0 || j2 > m) continue;
                    int t = w[i1][j1];
                    if (i1 != i2)  t += w[i2][j2];
                    dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k - 1][i1 - 1][i2 - 1] + t);
                    dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k - 1][i1 - 1][i2] + t);
                    dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k - 1][i1][i2 - 1] + t);
                    dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k - 1][i1][i2] + t);
                }
            }
        }
        System.out.println(dp[m+n][n][n]);
    }

}

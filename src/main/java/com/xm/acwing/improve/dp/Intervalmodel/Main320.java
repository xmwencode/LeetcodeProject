package com.xm.acwing.improve.dp.Intervalmodel;

import java.util.Scanner;

public class Main320 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] w = new int[2 * n + 1];
        int[][] dp = new int[2 * n + 1][2 * n + 1];
        for (int i = 1; i <= n; i++) {
            w[i] = w[i + n] = sc.nextInt();
        }
        // 注意一共需要合并 n 次
        for (int len = 2; len <= n + 1; len++) {
            for (int l = 1, r = l + len - 1; r < 2 * n + 1; l++, r++) {
                for (int k = l + 1; k < r; k++) {
                    dp[l][r] = Math.max(dp[l][r], dp[l][k] + dp[k][r] + w[l] * w[r] * w[k]);
                }
            }
        }
        int res = 0;
        for (int l = 1; l <= n; l++) {
            res = Math.max(res, dp[l][l + n]);
        }
        System.out.println(res);
    }
}

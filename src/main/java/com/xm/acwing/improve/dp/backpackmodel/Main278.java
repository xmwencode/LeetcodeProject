package com.xm.acwing.improve.dp.backpackmodel;

import java.util.Scanner;

public class Main278 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // dp[j] 总和为 j 的方案总数
        int[] dp = new int[m + 1];
        // 和为 0 时不选也是一种方案
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
           int v = sc.nextInt();
            for (int j = m; j >= v; j--) {
                dp[j] += dp[j - v];
            }
        }
        System.out.println(dp[m]);
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] v = new int[n + 1];
        // dp[i, j] 前 i 个数和为 j 的方案总数
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
        }
        // 和为 0 时不选也是一种方案
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= v[i]) {
                    dp[i][j] += dp[i - 1][j - v[i]];
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}

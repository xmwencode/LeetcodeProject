package com.xm.acwing.improve.dp.digitaltrianglemodel;

import java.util.Scanner;

public class Main1049 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            // dp[i, 0] 表示不洗劫当前家
            // dp[i, 1] 表示洗劫当前家
            int[][] dp = new int[n + 1][2];
            int[] w = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                w[i] = sc.nextInt();
            }
            for (int i = 1; i <= n; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
                dp[i][1] = dp[i - 1][0] + w[i];
            }
            int res = 0;
            for (int i = 1; i <= n; i++) {
                res = Math.max(res, dp[i][0]);
                res = Math.max(res, dp[i][1]);
            }
            System.out.println(res);
        }

    }
}

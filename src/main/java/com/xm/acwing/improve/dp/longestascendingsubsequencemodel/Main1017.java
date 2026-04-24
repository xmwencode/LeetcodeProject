package com.xm.acwing.improve.dp.longestascendingsubsequencemodel;

import java.util.Scanner;

public class Main1017 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            // dp[i][0]: 以第 i 个建筑结尾的最长上升子序列
            // dp[i][1]: 以第 i 个建筑结尾的最长下降子序列
            int[][] dp = new int[n][2];
            int[] w = new int[n];
            for (int i = 0; i < n; i++) {
                w[i] = sc.nextInt();
            }
            int res = 0;
            // 求最长上升/下降子序列
            for (int i = 0; i < n; i++) {
                dp[i][0] = dp[i][1] = 1;
                for (int j = 0; j < i; j++) {
                    if (w[i] > w[j]) {
                        dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
                    } else if (w[i] < w[j]) {
                        dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
                    }
                }
                res = Math.max(res, dp[i][0]);
                res = Math.max(res, dp[i][1]);
            }
            System.out.println(res);
        }
    }

}

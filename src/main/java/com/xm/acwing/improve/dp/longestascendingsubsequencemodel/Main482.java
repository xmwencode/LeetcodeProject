package com.xm.acwing.improve.dp.longestascendingsubsequencemodel;

import java.util.Scanner;

public class Main482 {

    public static void main(String[] args) {
        // 有序队列即最长双端单调子序列
        // 最少需要几位同学出列，即求 n - 最长双端单调子序列
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // dp[i][0]: 以第 i 个建筑结尾的最长上升子序列
        // dp[i][1]: 以第 i 个建筑开头的最长下降子序列
        int[][] dp = new int[n][2];
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        // 求以第 i 个建筑结尾的最长上升子序列
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
            for (int j = 0; j < i; j++) {
                if (w[i] > w[j]) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
                }
            }
        }
        // 求第 i 个建筑开头的最长下降子序列
        for (int i = n - 1; i >= 0; i--) {
            dp[i][1] = 1;
            for (int j = i + 1; j < n; j++) {
                if (w[i] > w[j]) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i][0] + dp[i][1] - 1);
        }
        System.out.println(n - res);

    }
}

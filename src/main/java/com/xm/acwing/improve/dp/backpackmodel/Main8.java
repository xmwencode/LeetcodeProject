package com.xm.acwing.improve.dp.backpackmodel;

import java.util.Scanner;

public class Main8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        int[][] dp = new int[m + 1][t + 1];
        for (int i = 0; i < n; i++) {
            int vv = sc.nextInt();
            int ww = sc.nextInt();
            int ss = sc.nextInt();
            for (int j = m; j >= 0; j--) {
                for (int k = t; k >= 0; k--) {
                    if (j >= vv && k >= ww) {
                        dp[j][k] = Math.max(dp[j][k], dp[j - vv][k - ww] + ss);
                    }
                }
            }
        }
        System.out.println(dp[m][t]);
    }
}

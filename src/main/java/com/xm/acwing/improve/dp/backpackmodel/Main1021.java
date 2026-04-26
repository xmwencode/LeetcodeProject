package com.xm.acwing.improve.dp.backpackmodel;

import java.util.Scanner;

public class Main1021 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int v = sc.nextInt();
            for (int j = v; j <= m; j++) {
                dp[j] += dp[j - v];
            }
        }
        System.out.println(dp[m]);
    }
}

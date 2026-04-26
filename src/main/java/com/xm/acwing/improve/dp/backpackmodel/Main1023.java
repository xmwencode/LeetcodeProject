package com.xm.acwing.improve.dp.backpackmodel;

import java.util.Scanner;

public class Main1023 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = 4;
        int[] v = new int[]{0, 10, 20, 50, 100};
        int[] dp = new int[m + 1];
        dp[0] = 1;
        // 完全背包问题
        for (int i = 1; i <= n; i++) {
            for (int j = v[i]; j <= m; j++) {
                dp[j] += dp[j - v[i]];
            }
        }
        System.out.println(dp[m]);
    }
}

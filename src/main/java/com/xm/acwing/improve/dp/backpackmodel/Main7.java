package com.xm.acwing.improve.dp.backpackmodel;

import java.util.Scanner;

public class Main7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dp = new int[m + 1];
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            int w = sc.nextInt();
            int s = sc.nextInt();
            if (s == 0) {
                for (int j = v; j <= m; j++) {
                    dp[j] = Math.max(dp[j], dp[j - v] + w);
                }
            } else {
                // 01 背包问题可看作个数限制为 1 的多重背包问题
                if (s == -1) s = 1;
                for (int j = m; j >= 0; j--) {
                    for (int k = 0; k <= s && k * v <= j; k++) {
                        dp[j] = Math.max(dp[j], dp[j - v * k] + w * k);
                    }
                }
            }
        }
        System.out.println(dp[m]);
    }
}

package com.xm.acwing.improve.dp.backpackmodel;

import java.util.Scanner;

public class Main1019 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // dp[j]: 不超过 j 金额能获取的最大价值
        int[] dp = new int[m + 1];
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            int w = sc.nextInt();
            int s = sc.nextInt();
            for (int j = m; j >= 0; j--) {
                for (int k = 0; k <= s && k * v <= j; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * v] + k * w);
                }
            }
        }
        System.out.println(dp[m]);
    }
}

package com.xm.acwing.improve.dp.backpackmodel;

import java.util.Scanner;

public class Main1020 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int m2 = sc.nextInt();
        int n = sc.nextInt();
        // d[i, j]: 氧气含量不少于 i, 氮气含量不少于 j，潜水器的最小重量
        int[][] dp = new int[m1 + 1][m2 + 1];
        for (int i = 0; i <= m1; i++) {
            for (int j = 0; j <= m2; j++) {
                dp[i][j] = 0x3f3f3f3f;
            }
        }
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            int v1 = sc.nextInt(); // 氧气含量
            int v2 = sc.nextInt(); // 氮气含量
            int w = sc.nextInt(); // 气缸重量
            for (int j = m1; j >= 0; j--) {
                for (int k = m2; k >= 0; k--) {
                    dp[i][j] = Math.min(dp[i][j],
                            // 注意氧气/氮气可以冗余，但最小值为0
                            dp[Math.max(0, j - v1)][Math.max(0, k - v2)] + w
                    );
                }
            }
        }
        System.out.println(dp[m1][m2]);
    }
}

package com.xm.acwing.improve.dp.Intervalmodel;

import java.util.Scanner;

public class Main282 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] w = new int[n + 1];
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
            s[i] = s[i - 1] + w[i];
        }
        // dp[i, j]: 合并 [i, j] 石子需要的最小代价
        int[][] dp = new int[n + 1][n + 1];

        for (int len = 2; len <= n; len++) {
            for (int l = 1, r = l + len - 1; r <= n; l++, r++) {
                dp[l][r] = 0x3f3f3f3f;
                for (int mid = l; mid < r; mid++) {
                    dp[l][r] = Math.min(
                            dp[l][r],
                            dp[l][mid] + dp[mid + 1][r] + s[r] - s[l - 1]
                    );
                }
            }
        }
        System.out.println(dp[1][n]);
    }
}

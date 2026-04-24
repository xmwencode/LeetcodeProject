package com.xm.acwing.improve.dp.digitaltrianglemodel;

import java.io.IOException;
import java.util.Scanner;

public class Main1058 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // dp[i, 0]: 当前第 i 天，手中没有股票的天数 = 1
        // dp[i, 1]: 当前第 i 天，手中没有股票的天数 >= 2
        // dp[i, 2]: 当前第 i 天，手中有股票
        int[][] dp = new int[n + 1][3];
        int[] w = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = dp[i][2] = -0x3f3f3f3f;
        }
        for (int i = 1; i <= n; i++) {
            // 手中没有股票的第一天: 昨天有今天卖出
            dp[i][0] = dp[i - 1][2] + w[i];
            // 手中没有股票 >= 2天: 昨天没有股票
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            // 手中有股票: 昨天就有，昨天没有今天买的
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - w[i]);
        }
        System.out.println(Math.max(dp[n][0], dp[n][1]));
    }
}

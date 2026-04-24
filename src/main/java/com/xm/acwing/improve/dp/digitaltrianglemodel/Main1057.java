package com.xm.acwing.improve.dp.digitaltrianglemodel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1057 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] st = bf.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);
        // dp[i, k, 0] 表示这是在第 i 天进行第 k 笔交易，当前手中没有股票
        // dp[i, k, 1] 表示这是在第 i 天进行第 k 笔交易，当前手中有股票
        String[] str = bf.readLine().split(" ");
        int[][][] dp = new int[n + 1][m + 1][2];
        int[] w = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            w[i] = Integer.parseInt(str[i - 1]);
        }
        //将所有状态初始化成负无穷，所有状态一开始都是不成立的
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= m; j++)
                for (int k = 0; k < 2; k++) {
                    dp[i][j][k] = -0x3f3f3f3f;
                }
        for (int i = 1; i <= n; i++) {
            dp[i][0][0] = dp[i - 1][0][0];
            dp[i][0][1] = -0x3f3f3f3f;
            for (int k = 1; k <= m; k++) {
                // 当前没有股票，要么昨天就没有，要么昨天有今天卖出了
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + w[i]);
                // 当前有股票，要么昨天就有，要么昨天没有今天买的
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - w[i]);
            }
        }
        int res = 0;
        for (int k = 0; k <= m; k++) {
            res = Math.max(res, dp[n][k][0]);
        }

        System.out.println(res);
    }
}

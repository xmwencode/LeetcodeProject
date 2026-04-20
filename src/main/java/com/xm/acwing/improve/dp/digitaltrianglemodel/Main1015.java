package com.xm.acwing.improve.dp.digitaltrianglemodel;

import java.util.Arrays;
import java.util.Scanner;

public class Main1015 {

    static int n;
    static int m;
    static int N = 110;
    static int[][] w = new int[N][N];
    static int[][] dp = new int[N][N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            for (int i = 0; i <= n; i++) {
                Arrays.fill(dp[i], 0);
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    w[i][j] = sc.nextInt();
                }
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + w[i][j];
                }
            }
            System.out.println(dp[n][m]);
        }
    }

}

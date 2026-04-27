package com.xm.acwing.improve.dp.backpackmodel;

import java.util.Scanner;

public class Main11 {

    private static int mod = (int) 1e9 + 7;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] f = new int[n + 1][m + 1];
        int[][] s = new int[n + 1][m + 1];

        for (int i = 0; i <= m; i++) {
            s[0][i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            int v = sc.nextInt();
            int w = sc.nextInt();
            for (int j = 0; j <= m; j++) {
                f[i][j] = f[i - 1][j];
                s[i][j] = s[i - 1][j];
                if (j >= v && f[i - 1][j - v] + w > f[i][j]) {
                    f[i][j] = f[i - 1][j - v] + w;
                    s[i][j] = s[i - 1][j - v];
                } else if (j >= v && f[i - 1][j - v] + w == f[i][j]) {
                    s[i][j] = (s[i - 1][j] + s[i - 1][j - v]) % mod;
                }
            }
        }
        System.out.println(s[n][m]);
    }
}

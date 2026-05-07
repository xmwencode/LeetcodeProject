package com.xm.acwing.improve.dp.Intervalmodel;

import java.util.Scanner;

public class Main1068 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] w = new int[2 * n + 1];
        int[] s = new int[2 * n + 1];
        for (int i = 1; i <= n; i++) {
            w[i] = w[i + n] = sc.nextInt();
        }
        for (int i = 1; i <= 2 * n; i++) {
            s[i] = s[i - 1] + w[i];
        }
        // dp[i, j]: 合并 [i, j] 石子需要的最大/最小代价
        int[][] f = new int[2 * n + 1][2 * n + 1];
        int[][] g = new int[2 * n + 1][2 * n + 1];

        for (int len = 2; len <= 2 * n; len++) {
            for (int l = 1, r = l + len - 1; r <= 2 * n; l++, r++) {
                f[l][r] = 0x3f3f3f3f;
                for (int k = l; k < r; k++) {
                    f[l][r] = Math.min(f[l][r], f[l][k] + f[k + 1][r] + s[r] - s[l - 1]);
                    g[l][r] = Math.max(g[l][r], g[l][k] + g[k + 1][r] + s[r] - s[l - 1]);
                }
            }
        }
        // 进行 n - 1 次合并后长度为 len = n - 1
        int max = 0, min = Integer.MAX_VALUE;
        for (int l = 1, r = l + n - 1; r < n << 1; l++, r++) {
            min = Math.min(min, f[l][r]);
            max = Math.max(max, g[l][r]);
        }
        System.out.println(min);
        System.out.println(max);
    }
}

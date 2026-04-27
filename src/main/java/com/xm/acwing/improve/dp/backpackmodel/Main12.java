package com.xm.acwing.improve.dp.backpackmodel;

import java.util.Scanner;

public class Main12 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] f = new int[n + 2][m + 1];
        // s[i, j] 前 i 件物品，容量限制为 j 时，是否选择第 i 件物品
        boolean[][] s = new boolean[n + 2][m + 1];
        int[] v = new int[n + 2];
        int[] w = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        // 要求字典序最小输出，所以必须逆序更新，这样取等时就会更新为最前面的物品
        for (int i = n; i >= 1; i--) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = f[i + 1][j];
                if (j >= v[i] && f[i][j] <= f[i + 1][j - v[i]] + w[i]) {
                    f[i][j] = f[i + 1][j - v[i]] + w[i];
                    s[i][j] = true;
                }
            }
        }
        // 递归写法
        // dfs(1, n, m, v, s);

        // 迭代写法
        int u = 1;
        int j = m;
        while (u <= n) {
            if (s[u][j]) {
                System.out.print(u + " ");
                j -= v[u];
            }
            u++;
        }
    }

    private static void dfs(int u, int n, int j, int[] v, boolean[][] s) {
        if (u > n) return;
        if (s[u][j]) {
            System.out.print(u + " ");
            dfs(u + 1, n, j - v[u], v, s);
        } else dfs(u + 1, n, j, v, s);
    }
}

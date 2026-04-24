package com.xm.acwing.improve.dp.digitaltrianglemodel;

import java.util.Scanner;

public class Main1052 {

    static int N = 55, mod = (int) 1e9 + 7;

    public static void main(String[] args) {
        // f[i, j] 当前来到第 i 位密码，在 kmp 的过程中跳到状态 j 的方案数量
        int[][] f = new int[N][N];
        // 存储 T 字符串
        char[] str = new char[N];
        // next[] 数组
        int[] ne = new int[N];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int m = s.length();
        for (int i = 1; i <= m; i++) {
            str[i] = s.charAt(i - 1);
        }
        // 预处理 next
        for (int i = 2, j = 0; i <= m; i++) {
            while (j != 0 && str[i] != str[j + 1]) j = ne[j];
            if (str[i] == str[j + 1]) j++;
            ne[i] = j;
        }
        // 初始化：当前已经枚举了 0 位密码，状态 0 也是一种状态
        f[0][0] = 1;
        // 枚举 n 位密码进行 KMP 匹配
        for (int i = 1; i <= n; i++) {
            // 当前枚举到第 i 位，有 26 种字母
            for (char c = 'a'; c <= 'z'; c++) {
                // 枚举上一步的【合法状态】j（0~m-1）
                for (int j = 0; j < m; j++) {
                    // 如果与 T 的前 j 个字符匹配就是状态 j
                    int u = j;
                    while (u != 0 && c != str[u + 1]) u = ne[u];
                    if (c == str[u + 1]) u++;
                    // 枚举的长度没有超过 m, 说明状态合法, j 能够跳到 u
                    if (u < m) {
                        f[i][u] = (f[i][u] + f[i - 1][j]) % mod;
                    }
                }
            }
        }
        // 最后将写了 i 为密码的所有状态数量累加
        int res = 0;
        for (int i = 0; i < m; i++) {
            res = (res + f[n][i]) % mod;
        }
        System.out.println(res);
    }
}

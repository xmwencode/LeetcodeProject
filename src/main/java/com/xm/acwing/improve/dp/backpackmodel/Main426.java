package com.xm.acwing.improve.dp.backpackmodel;

import java.util.Scanner;

public class Main426 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] dp = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            int v = sc.nextInt();
            int p = sc.nextInt();
            for (int j = m; j > v; j--) {
                dp[j] = Math.max(dp[j], dp[j - v] + v * p);
            }
        }
        System.out.println(dp[m]);
    }
}

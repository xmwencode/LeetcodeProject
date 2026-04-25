package com.xm.acwing.improve.dp.backpackmodel;

import java.util.Scanner;

public class Main1022 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int p = sc.nextInt();
        int n = sc.nextInt();
        // dp[i, j, k]: 前 i 个精灵，精灵球不多于 j，体力值不多于 k，
        int[][] dp = new int[m + 1][p + 1];
        for (int i = 1; i <= n; i++) {
            int cnt = sc.nextInt(); // 需要的精灵球
            int hurt = sc.nextInt(); // 造成的伤害
            for (int j = m; j >= cnt; j--) {
                for (int k = p; k > hurt; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - cnt][k - hurt] + 1);
                }
            }
        }
        System.out.print(dp[m][p] + " ");
        if (dp[m][p] == 0) {
            System.out.println(p);
            return;
        }
        // 寻找最少伤害
        int res = p;
        while (dp[m][p] == dp[m][res]) res--;
        System.out.println(p - res);
    }
}

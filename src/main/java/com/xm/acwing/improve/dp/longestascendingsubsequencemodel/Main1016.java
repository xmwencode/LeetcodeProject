package com.xm.acwing.improve.dp.longestascendingsubsequencemodel;

import java.util.Scanner;

public class Main1016 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        // dp[i] 表示以第 i 个数结尾的【最大上升子序列的和】
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = w[i];
            for (int j = 0; j < i; j++) {
                if (w[i] > w[j]) {
                    // 将求长度改为求权值和即可
                    dp[i] = Math.max(dp[i], dp[j] + w[i]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        System.out.println(res);
    }

}

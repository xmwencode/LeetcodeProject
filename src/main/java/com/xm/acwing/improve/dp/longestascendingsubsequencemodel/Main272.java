package com.xm.acwing.improve.dp.longestascendingsubsequencemodel;

import java.util.Scanner;

public class Main272 {

    // 优化
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        int[] b = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            b[i] = sc.nextInt();
        }
        // dp[i, j]: 由 a 的前 i 个字母与 b 的前 j 个字母中能构成的最长公共上升子序列
        // 同时需要存当前公共上升子序列的末尾值，所以不妨状态定义时添加 "以 b[j] 结尾" 的限制
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            int maxv = 1; // 上升子序列最短为 1
            for (int j = 1; j <= n; j++) {
                // 1.不以 a[i] 结尾
                dp[i][j] = dp[i - 1][j];
                // 2.以 a[i] 结尾
                if (a[i] == b[j]) {
                    // 情况1：a[i]和b[j]相等 → 可以拼接成公共子序列
                    // maxv已经存了所有b[k]<a[i]的最大长度，直接用！
                    dp[i][j] = Math.max(dp[i][j], maxv);
                } else if (a[i] > b[j]) {
                    // 情况2：b[j]比a[i]小 → 这个b[j]可以作为后续上升子序列的前序元素
                    // 更新maxv：保留最大的dp[i-1][j]+1
                    maxv = Math.max(dp[i - 1][j] + 1, maxv);
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, dp[n][i]);
        }
        System.out.println(res);
    }


    // 朴素做法
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        int[] b = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            b[i] = sc.nextInt();
        }
        // dp[i, j]: 由 a 的前 i 个字母与 b 的前 j 个字母中能构成的最长公共上升子序列
        // 同时需要存当前公共上升子序列的末尾值，所以不妨状态定义时添加 "以 b[j] 结尾" 的限制
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // 不以 a[i] 结尾
                dp[i][j] = dp[i - 1][j];
                // 以 a[i] 结尾
                if (a[i] == b[j]) {
                    // 在 0 ... j - 1 中找能够构成上升子序列的数
                    for (int k = 0; k < j; k++) {
                        if (b[j] > b[k]) {
                            // 要保证上升，需要找 所有 k < j 且 b[k] < b[j] 的 dp[i-1][k] 最大值，再加 1
                            /*  dp[i][j] = max{ dp[i-1][k] } + 1 （k<j，b[k]<b[j]） */
                            dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + 1);
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, dp[n][i]);
        }
        System.out.println(res);
    }
}

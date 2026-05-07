package com.xm.acwing.improve.dp.Intervalmodel;

import java.util.Arrays;
import java.util.Scanner;

public class Main479 {

    private static int N = 35;
    private static int[][] f = new int[N][N]; // 记录最值
    private static int[][] s = new int[N][N]; // 记录在 (l, r) 中选择的根节点
    private static int[] w = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // dp[l,r]: 以 l 为左端点，r 为右端点的区间，生成的树的最大分数
        // int[][] dp = new int[n + 1][n + 1]; 记忆化搜索
        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
        }
        for (int i = 0; i <= n; i++) {
            Arrays.fill(f[i], -1);
        }
        System.out.println(dp(1, n));
        dfs(1, n);
    }

    private static void dfs(int l, int r) {
        if (l > r) return;
        int root = s[l][r];
        System.out.print(root + " ");
        dfs(l, root - 1);
        dfs(root + 1, r);
    }

    private static int dp(int l, int r) {
        // 已经搜索过直接退出
        if (f[l][r] != -1) {
            return f[l][r];
        }
        // 只有一个节点，直接返回
        if (l == r) {
            f[l][r] = w[l];
            s[l][r] = l;
            return w[l];
        }
        // 空子树直接返回
        if (l > r) {
            return 1;
        }
        // 当前树的得分 = 左 * 右 + 根
        int score = Integer.MIN_VALUE;
        // 枚举根节点
        for (int root = l; root <= r; root++) {
            int curr = dp(l, root - 1) * dp(root + 1, r) + w[root];
            if (curr > score) {
                score = curr;
                f[l][r] = score;
                s[l][r] = root;
            }
        }
        return score;
    }
}

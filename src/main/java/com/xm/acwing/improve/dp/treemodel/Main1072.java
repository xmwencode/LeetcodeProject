package com.xm.acwing.improve.dp.treemodel;

import java.util.Arrays;
import java.util.Scanner;

public class Main1072 {

    private static int N = 20010;
    private static int[] e = new int[N];
    private static int[] ne = new int[N];
    private static int[] w = new int[N];
    private static int[] h = new int[N];
    private static int idx;
    private static int res;

    // dp[u, 0] 以 u 为根节点的最长子树路径
    // dp[u, 1] 以 u 为根节点的次长子树路径
    private static int[][] dp = new int[N][2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Arrays.fill(h, -1);
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            add(a, b, c);
            add(b, a, c);
        }
        dfs(1, -1);
        System.out.println(res);
    }

    /**
     * @param u 当前根节点
     * @param fa 当前节点的父节点
     */
    private static void dfs(int u, int fa) {
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (j == fa) continue;
            dfs(j, u);
            // 更新最大值
            if (dp[u][0] <= dp[j][0] + w[i]) {
                dp[u][1] = dp[u][0];
                dp[u][0] = dp[j][0] + w[i];
            } else if (dp[u][1] <= dp[j][0] + w[i]) {
                // 更新次大值
                dp[u][1] = dp[j][0] + w[i];
            }
        }
        res = Math.max(res, dp[u][0] + dp[u][1]);
    }

    private static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}

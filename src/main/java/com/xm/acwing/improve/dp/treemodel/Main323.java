package com.xm.acwing.improve.dp.treemodel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main323 {

    private static int N = 3010;
    private static int[] h = new int[N];
    private static int[] e = new int[N];
    private static int[] ne = new int[N];
    private static int idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = br.readLine();
            if (str == null) return;
            int n = Integer.parseInt(str);
            boolean[] st = new boolean[n];
            Arrays.fill(h, -1);
            idx = 0;
            // dp[u, 0] 以 u 为根的子树中，士兵不放在 u 上的最小数量
            // dp[u, 1] 以 u 为根的子树中，士兵放在 u 上的最小数量
            int[][] dp = new int[n][2];
            for (int i = 0; i < n; i++) {
                String[] strs = br.readLine().split(":");
                int a = Integer.parseInt(strs[0]);
                String[] sons = strs[1].split(" ");
                for (int j = 1; j < sons.length; j++) {
                    int b = Integer.parseInt(sons[j]);
                    add(a, b);
                    st[b] = true;
                }
            }
            // 找到根节点
            int root = 0;
            while (st[root]) root++;
            dfs(root, dp);
            System.out.println(Math.min(dp[root][0], dp[root][1]));
        }
    }

    private static void dfs(int u, int[][] dp) {
        dp[u][0] = 0;
        dp[u][1] = 1;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int son = e[i];
            dfs(son, dp);
            // 不放在 u 节点上士兵，子节点必须放置士兵
            dp[u][0] += dp[son][1];
            // 放在 u 节点上士兵，子节点可以放置不放置士兵
            dp[u][1] += Math.min(dp[son][0], dp[son][1]);
        }
    }

    private static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}

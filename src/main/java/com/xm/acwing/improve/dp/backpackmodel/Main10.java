package com.xm.acwing.improve.dp.backpackmodel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 树形背包
 */
public class Main10 {


    // 手写树实现
    public static class Main {
        private static int N = 110;
        private static int n, m;
        private static final int[][] dp = new int[N][N];

        private static class TreeNode {
            public int id;
            public int v;
            public int w;
            List<TreeNode> children;

            TreeNode() {
                children = new ArrayList<>();
            }

            TreeNode(int id, int v, int w) {
                this.id = id;
                this.v = v;
                this.w = w;
                this.children = new ArrayList<>();
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            m = sc.nextInt();
            // 存储节点
            TreeNode[] tree = new TreeNode[n + 1];
            // 存储每个节点的父节点
            int[] parents = new int[n + 1];
            TreeNode root = null;
            for (int i = 1; i <= n; i++) {
                int v = sc.nextInt();
                int w = sc.nextInt();
                int p = sc.nextInt();
                parents[i] = p;
                tree[i] = new TreeNode(i, v, w);
                if (p == -1) {
                    root = tree[i];
                }
            }
            // 创建依赖树
            for (int i = 1; i <= n; i++) {
                int p = parents[i];
                if (p != -1) {
                    tree[p].children.add(tree[i]);
                }
            }
            dfs(root);
            System.out.println(dp[root.id][m]);
        }

        private static void dfs(TreeNode u) {
            // 遍历所有节点
            u.children.forEach(son -> {
                dfs(son);
                // 选该子节点，必须要选父节点，分组背包
                for (int j = m - u.v; j >= 0; j--) {
                    for (int k = 0; k <= j; k++) {
                        dp[u.id][j] = Math.max(
                                dp[u.id][j],
                                dp[u.id][j - k] + dp[son.id][k]
                        );
                    }
                }
            });
            // 必须选择当前节点
            for (int j = m; j >= u.v; j--) {
                dp[u.id][j] = dp[u.id][j - u.v] + u.w;
            }
            // 容量不足，无法选择当前节点
            for (int j = 0; j < u.v; j++) {
                dp[u.id][j] = 0;
            }
        }
    }
}

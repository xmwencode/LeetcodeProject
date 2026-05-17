package com.xm.acwing.improve.graph.dijkstra;

import java.util.Arrays;
import java.util.Scanner;

public class Main849 {

    static int N = 510;
    static int INF = 0x3f3f3f3f;
    static int[] dist = new int[N];
    static int[][] grid = new int[N][N];
    static boolean[] st = new boolean[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int[] d : grid) {
            Arrays.fill(d, INF);
        }
        for (int i = 1; i <= n; i++) {
            grid[i][i] = 0;
        }
        while (m-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            grid[a][b] = Math.min(grid[a][b], c);
        }
        Arrays.fill(dist, INF);
        dist[1] = 0;
        st[0] = true;
        for (int i = 1; i <= n; i++) {
            int t = -1;
            // 找到没有确定最短距离的点中，距离原点最近的点
            for (int j = 1; j <= n; j++) {
                if (!st[j] && (t == -1 || dist[t] > dist[j])) {
                    t = j;
                }
            }
            // 确定该点当前为最短距离，并更新其他点的距离
            for (int j = 1; j <= n; j++) {
                if (!st[j]) {
                    dist[j] = Math.min(dist[j], dist[t] + grid[t][j]);
                }
            }
            // 标记当前点的最短距离已确定
            st[t] = true;
        }

        int res = dist[n] > INF / 2 ? -1 : dist[n];
        System.out.println(res);
    }

}

package com.xm.acwing.improve.graph.bellmanford;

import java.util.Arrays;
import java.util.Scanner;

public class Main853 {

    static int N = 510, M = 10010, INF = 0x3f3f3f3f;
    static int[] dist = new int[N];
    static Edge[] edges = new Edge[M];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            edges[i] = new Edge(a, b, c);
        }

        Arrays.fill(dist, INF);
        dist[1] = 0;

        // 总共不超过 k 条边，就用每一条边更新相连点的距离，更新 k 次即可
        for (int i = 1; i <= k; i ++ ) {
            int[] back = Arrays.copyOf(dist, dist.length);
            for (int j = 0; j < m; j++) {
                int a = edges[j].a, b = edges[j].b, c = edges[j].c;
                dist[b] = Math.min(dist[b], back[a] + c);
            }
        }

        if (dist[n] > INF / 2) {
            System.out.println("impossible");
        } else {
            System.out.println(dist[n]);
        }
    }

    static class Edge{
        int a, b, c;
        public Edge(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}

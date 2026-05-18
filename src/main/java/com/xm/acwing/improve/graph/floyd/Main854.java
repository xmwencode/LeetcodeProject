package com.xm.acwing.improve.graph.floyd;

import java.util.Arrays;
import java.util.Scanner;

public class Main854 {

    static int N = 210, INF = 0x3f3f3f3f;
    static int[][] dist = new int[N][N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        for (int[] row : dist) {
            Arrays.fill(row, INF);
        }
        for (int i = 1; i <= n; i ++ ) {
            dist[i][i] = 0;
        }
        while(m -- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            dist[a][b] = Math.min(dist[a][b], c);
        }
        // floyd 算法
        for (int k = 1; k <= n; k ++ ) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        while (q-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (dist[a][b] > INF /2) {
                System.out.println("impossible");
            } else {
                System.out.println(dist[a][b]);
            }
        }
    }
}

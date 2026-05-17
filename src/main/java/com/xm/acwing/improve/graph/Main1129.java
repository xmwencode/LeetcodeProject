package com.xm.acwing.improve.graph;

import java.util.*;

public class Main1129 {

    static int N = 13000, idx;
    static int INF = 0x3f3f3f3f;
    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int[] w = new int[N];
    static boolean[] st = new boolean[N];
    static int[] dist = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();
        int end = sc.nextInt();
        Arrays.fill(h, -1);
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (a == b) continue;
            add(a, b, c);
            add(b, a, c);
        }
        System.out.println(dijkstra(start, end));
    }

    static int dijkstra(int start, int end) {
        Arrays.fill(dist, INF);
        dist[start] = 0;
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        queue.add(Map.entry(start, 0));
        while (!queue.isEmpty()) {
            Map.Entry<Integer, Integer> entry = queue.poll();
            int t = entry.getKey();
            int distance = entry.getValue();
            if (st[t]) continue;
            st[t] = true;
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > distance + w[i]) {
                    dist[j] = distance + w[i];
                    if (!st[j]) {
                        queue.add(Map.entry(j, dist[j]));
                    }
                }
            }
        }
        return dist[end];
    }

    static void add(int a, int b, int c) {
        e[idx] = b;
        ne[idx] = h[a];
        w[idx] = c;
        h[a] = idx++;
    }
}

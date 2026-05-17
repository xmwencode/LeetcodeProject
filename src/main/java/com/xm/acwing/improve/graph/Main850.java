package com.xm.acwing.improve.graph;

import java.util.*;

public class Main850 {

    static int N = 300010;
    static int INF = 0x3f3f3f3f;
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int[] w = new int[N];
    static int[] h = new int[N];
    static int[] dist = new int[N];
    static int idx;
    static boolean[] st = new boolean[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Arrays.fill(dist, INF);
        Arrays.fill(h, -1);
        while (m-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (a == b) continue;
            add(a, b, c);
        }
        dist[1] = 0;
        // key: 当前点 value: 距离
        PriorityQueue<Map.Entry<Integer, Integer>> queue =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        queue.add(Map.entry(1, 0));
        while (!queue.isEmpty()) {
            Map.Entry<Integer, Integer> poll = queue.poll();
            int u = poll.getKey();
            int distance = poll.getValue();
            // 用当前点更新其他没有确定最短距离的点
            if (st[u]) continue;
            st[u] = true;

            for (int i = h[u]; i != -1; i = ne[i]) {
                int j = e[i];
                if (!st[j] && dist[j] > distance + w[i]) {
                    dist[j] = distance + w[i];
                    queue.add(Map.entry(j, dist[j]));
                }
            }
        }

        int res = dist[n] > INF / 2 ? -1 : dist[n];
        System.out.println(res);
    }

    static void add(int a, int b, int c) {
        e[idx] = b;
        ne[idx] = h[a];
        w[idx] = c;
        h[a] = idx++;
    }
}

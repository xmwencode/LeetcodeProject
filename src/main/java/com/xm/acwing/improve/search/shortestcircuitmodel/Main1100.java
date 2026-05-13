package com.xm.acwing.improve.search.shortestcircuitmodel;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main1100 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] dist = new int[200010];
        Arrays.fill(dist, Integer.MIN_VALUE);
        Deque<Integer> q = new ArrayDeque<>();
        dist[n] = 0;
        q.add(n);
        while (!q.isEmpty()) {
            int x = q.poll();
            if (x == target) {
                System.out.println(dist[target]);
                return;
            }
            // 移动到 x + 1
            if (x + 1 <= 2 * target + 1 && dist[x + 1] < 0) {
                q.add(x + 1);
                dist[x + 1] = dist[x] + 1;
            }
            // 移动到 x - 1
            if (x - 1 >= 0 && dist[x - 1] < 0) {
                q.add(x - 1);
                dist[x - 1] = dist[x] + 1;
            }
            // 移动到 x * 2
            if (x < target && dist[x * 2] < 0) {
                q.add(x * 2);
                dist[x * 2] = dist[x] + 1;
            }
        }
    }
}

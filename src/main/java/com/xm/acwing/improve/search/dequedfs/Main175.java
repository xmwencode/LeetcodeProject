package com.xm.acwing.improve.search.dequedfs;

import java.util.*;

public class Main175 {

    private static char[] cs = new char[]{'\\', '/', '\\', '/'};
    // 四个方向的偏移量
    // x + dx[i], y + dy[i]: 下一个点的坐标
    private static int[] dx = {-1, -1, 1, 1}, dy = {-1, 1, 1, -1};
    // 从该偏移量偏移需要经过的方格的位置偏移量
    // x + lx[i], y + ly[i]: 到达下一个点需要经过的方格的坐标
    private static int[] lx = {-1, -1, 0, 0}, ly = {-1, 0, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            // 方向标志
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String line = sc.next();
                grid[i] = line.toCharArray();
            }
            if (((n + m) & 1) == 1) {
                System.out.println("NO SOLUTION");
                continue;
            }
            // 到达目标点需要旋转的最小次数：即定义为距离
            int[][] dist = new int[n + 1][m + 1];
            for (int[] d : dist) {
                Arrays.fill(d, 0x3f3f3f3f);
            }
            Deque<Map.Entry<Integer, Integer>> queue = new ArrayDeque<>();
            queue.addFirst(Map.entry(0, 0));
            dist[0][0] = 0;
            while (!queue.isEmpty()) {
                Map.Entry<Integer, Integer> entry = queue.pollFirst();
                int x = entry.getKey(), y = entry.getValue();
                // 到达终点，跳出循环
                if (x == n && y == m) break;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i], ny = y + dy[i];
                    if (nx < 0 || ny < 0 || nx > n || ny > m) continue;
                    // 由 (x, y) => (nx, ny) 经过的方格
                    int gx = x + lx[i], gy = y + ly[i];
                    int w = grid[gx][gy] == cs[i] ? 0 : 1;
                    int d = dist[x][y] + w;
                    if (d < dist[nx][ny]) {
                        dist[nx][ny] = d;
                        if (w == 0) queue.addFirst(Map.entry(nx, ny));
                        else queue.addLast(Map.entry(nx, ny));
                    }
                }
            }
            System.out.println(dist[n][m]);
        }
    }
}

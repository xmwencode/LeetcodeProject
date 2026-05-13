package com.xm.acwing.improve.search.shortestcircuitmodel;

import java.util.*;

public class Main1076 {

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        // 记录到达 [x, y] 的最短距离
        int[][] dist = new int[n][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        bfs(dist, grid);
    }

    private static void bfs(int[][] dist, int[][] grid) {
        Deque<Map.Entry<Integer, Integer>> queue = new ArrayDeque<>();
        int n = grid.length;
        queue.add(Map.entry(0, 0));
        dist[0][0] = 0;
        while (!queue.isEmpty()) {
            Map.Entry<Integer, Integer> entry = queue.poll();
            int x = entry.getKey(), y = entry.getValue();
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (grid[nx][ny] == 1) continue;
                if (dist[nx][ny] >= 0) continue;
                dist[nx][ny] = dist[x][y] + 1;
                queue.add(Map.entry(nx, ny));
            }
        }
        dfs(n - 1, n - 1, dist);
    }

    private static void dfs(int x, int y, int[][] dist) {
        int n = dist.length;
        for (int i = 0; i < 4; i++) {
            int lx = x + dx[i], ly = y + dy[i];
            if (lx < 0 || ly < 0 || lx >= n || ly >= n) continue;
            if (dist[x][y] - 1 == dist[lx][ly]) {
                dfs(lx, ly, dist);
                break;
            }
        }
        System.out.println(x + " " + y);
    }
}

package com.xm.acwing.improve.search.floodfillmodel;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Scanner;

public class Main1098 {

    private static int[] dx = {0, -1, 0, 1};
    private static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int ans = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j]) {
                    ans = Math.max(ans, bfs(i, j, vis, grid));
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(ans);
    }

    private static int bfs(int i, int j, boolean[][] vis, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Deque<Map.Entry<Integer, Integer>> queue = new ArrayDeque<>();
        queue.add(Map.entry(i, j));
        vis[i][j] = true;
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            Map.Entry<Integer, Integer> entry = queue.poll();
            int x = entry.getKey(), y = entry.getValue();
            for (int k = 0; k < 4; k++) {
                if ((grid[x][y] >> k & 1) == 1) continue;
                int nx = x + dx[k], ny = y + dy[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (!vis[nx][ny]) {
                    vis[nx][ny] = true;
                    queue.add(Map.entry(nx, ny));
                }
            }
        }
        return res;
    }
}

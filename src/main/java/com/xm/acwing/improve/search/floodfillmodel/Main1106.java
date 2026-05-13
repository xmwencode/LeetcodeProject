package com.xm.acwing.improve.search.floodfillmodel;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Scanner;

public class Main1106 {

    private static int[] dx = {-1, 0, 1, 0, -1, 1, 1, -1};
    private static int[] dy = {0, -1, 0, 1, -1, -1, 1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        boolean[][] vis = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int top = 0, valley = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j]) {
                    Map.Entry<Boolean, Boolean> bfs = bfs(i, j, vis, grid);
                    if (bfs.getKey()) top++;
                    if (bfs.getValue()) valley++;
                }
            }
        }
        System.out.println(top + " " + valley);
    }

    private static Map.Entry<Boolean, Boolean> bfs(int i, int j, boolean[][] vis, int[][] grid) {
        int n = grid.length;
        Deque<Map.Entry<Integer, Integer>> queue = new ArrayDeque<>();
        queue.add(Map.entry(i, j));
        vis[i][j] = true;
        // 标记该点是山峰还是山谷
        boolean isTop = true;
        boolean isValley = true;
        while (!queue.isEmpty()) {
            Map.Entry<Integer, Integer> entry = queue.poll();
            int x = entry.getKey(), y = entry.getValue();
            for (int k = 0; k < 8; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (grid[nx][ny] > grid[x][y]) isTop = false;
                if (grid[nx][ny] < grid[x][y]) isValley = false;
                if (!vis[nx][ny] && grid[nx][ny] == grid[x][y]) {
                    vis[nx][ny] = true;
                    queue.add(Map.entry(nx, ny));
                }
            }
        }
        return Map.entry(isTop, isValley);
    }
}

package com.xm.acwing.improve.search.floodfillmodel;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Scanner;

public class Main1097 {

    private static int n, m;
    private static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        char[][] grid = new char[n][m];
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = line.charAt(j);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'W' && !vis[i][j]) {
                    bfs(grid, vis, i, j);
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    private static void bfs(char[][] grid, boolean[][] vis, int i, int j) {
        Deque<Map.Entry<Integer, Integer>> queue = new ArrayDeque<>();
        queue.add(Map.entry(i, j));
        vis[i][j] = true;
        while (!queue.isEmpty()) {
            Map.Entry<Integer, Integer> entry = queue.poll();
            int x = entry.getKey();
            int y = entry.getValue();
            for (int k = 0; k < 8; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (grid[nx][ny] == 'W' && !vis[nx][ny]) {
                    queue.add(Map.entry(nx, ny));
                    vis[nx][ny] = true;
                }
            }
        }
    }
}

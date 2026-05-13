package com.xm.acwing.improve.search.shortestcircuitmodel;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Scanner;

public class Main188 {

    private static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        char[][] grid = new char[n][m];
        sc.nextLine();
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            String line = sc.next().trim();
            for (int j = 0; j < m; j++) {
                grid[i][j] = line.charAt(j);
                if (grid[i][j] == 'K') {
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println(bfs(x, y, grid));
    }

    private static int bfs(int i, int j, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Deque<Map.Entry<Integer, Integer>> queue = new ArrayDeque<>();
        queue.add(Map.entry(i, j));
        vis[i][j] = true;
        int res = 0;
        while (!queue.isEmpty()) {
            Deque<Map.Entry<Integer, Integer>> q = queue;
            queue = new ArrayDeque<>();
            res++;
            while (!q.isEmpty()) {
                Map.Entry<Integer, Integer> entry = q.poll();
                int x = entry.getKey(), y = entry.getValue();
                for (int k = 0; k < 8; k++) {
                    int nx = x + dx[k], ny = y + dy[k];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                    if (vis[nx][ny] || grid[nx][ny] == '*') continue;
                    if (grid[nx][ny] == 'H') {
                        return res;
                    }
                    queue.add(Map.entry(nx, ny));
                    vis[nx][ny] = true;
                }
            }
        }
        return -1;
    }
}

package com.xm.acwing.improve.search.shortestcircuitmodel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main173 {

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int[][] dist = new int[n][m];
        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }
        Deque<Map.Entry<Integer, Integer>> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                if (line.charAt(j) == '1') {
                    dist[i][j] = 0;
                    queue.offer(Map.entry(i, j));
                }
            }
        }
        while (!queue.isEmpty()) {
            Map.Entry<Integer, Integer> entry = queue.poll();
            int x = entry.getKey();
            int y = entry.getValue();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (dist[nx][ny] >= 0) continue;
                dist[nx][ny] = dist[x][y] + 1;
                queue.offer(Map.entry(nx, ny));
            }
        }

        for (int[] row : dist) {
            for (int x : row) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}

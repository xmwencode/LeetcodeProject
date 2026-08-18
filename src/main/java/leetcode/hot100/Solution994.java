package leetcode.hot100;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution994 {

    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    // 将所有腐烂的橘子加入队列
                    queue.offerLast(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            Deque<int[]> q = queue;
            queue = new ArrayDeque<>();
            // 用腐烂的橘子来扩散
            while (!q.isEmpty()) {
                int[] t = q.pollLast();
                int x = t[0], y = t[1];
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m
                            && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        queue.offerLast(new int[]{nx, ny});
                    }
                }
            }
            // 说明本轮有橘子被腐烂
            if (!queue.isEmpty()) {
                ans++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }
}
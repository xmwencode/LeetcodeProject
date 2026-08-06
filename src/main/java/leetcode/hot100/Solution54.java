package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int dirt = 0;
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
        int x = 0, y = 0;
        while (ans.size() < n * m) {
            ans.add(matrix[x][y]);
            matrix[x][y] = Integer.MAX_VALUE;
            int nx = x + dx[dirt], ny = y + dy[dirt];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m || matrix[nx][ny] == Integer.MAX_VALUE) {
                dirt = (dirt + 1) % 4;
            }
            x += dx[dirt];
            y += dy[dirt];
        }
        return ans;
    }
}
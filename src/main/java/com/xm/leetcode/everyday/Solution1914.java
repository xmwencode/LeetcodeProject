package com.xm.leetcode.everyday;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution1914 {
    private static final int[][] DIRS = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    public int[][] rotateGrid(int[][] grid, int k) {
        int n0 = grid.length;
        int m0 = grid[0].length;

        // 从外到内的层数由最短边决定
        for (int i = 0; i < Math.min(n0, m0) / 2; i++) {
            // 得到当前层的行列
            int n = n0 - i * 2;
            int m = m0 - i * 2;
            // 当前层最左上角的坐标
            int x = i, y = i;
            // 用于存储该层元素
            List<Integer> list = new ArrayList<>((m + n - 2) * 2);
            // 提取当前层的所有元素到列表
            for (int[] dir : DIRS) {
                // 遍历4个方向：右→下→左→上
                for (int j = 0; j < m - 1; j++) {
                    list.add(grid[x][y]);
                    x += dir[0];
                    y += dir[1];
                }
                // 交换行和列
                int tmp = m;
                m = n;
                n = tmp;
            }
            // 对当前列表进行旋转，即向左移动 k 位
            Collections.rotate(list, k);
            // 将移动后的元素重新填入矩阵中
            int index = 0;
            for (int[] dir : DIRS) {
                // 遍历4个方向：右→下→左→上
                for (int j = 0; j < m - 1; j++) {
                    grid[x][y] = list.get(index++);
                    x += dir[0];
                    y += dir[1];
                }
                // 交换行和列
                int tmp = m;
                m = n;
                n = tmp;
            }
        }
        return grid;
    }


}
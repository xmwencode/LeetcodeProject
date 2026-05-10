package com.xm.acwing.improve.search.dfspruningandoptimization;

import java.util.Arrays;
import java.util.Scanner;

public class Main166 {

    private static int N = 9, M = 1 << 9;
    // cnt[i]: 用于快速求出一个数中 1 的个数
    private static int[] cnt = new int[M];
    // log2[i]: 用于计算 log2(i) 的值
    private static int[] log2 = new int[M];

    public static void main(String[] args) {
        // 计算数字 i 中 1 的数量
        for (int i = 0; i < M; i++) {
            // 如果 i 的第 j 位是 1，就在结果中加上
            for (int j = 0; j < N; j++) {
                cnt[i] += (i >> j & 1);
            }
        }
        // 计算 logs[i]
        for (int i = 0; i < N; i++) {
            log2[1 << i] = i;
        }

        Scanner sc = new Scanner(System.in);
        while (true) {
            String line = sc.next();
            if (line.equals("end")) break;
            // 每个九宫格内的数字占用情况
            int[][] cell = new int[3][3];
            int[] col = new int[N];
            int[] row = new int[N];
            // 初始化，二进制的每一位都设为 1，表示该位数字还没有使用
            Arrays.fill(col, (1 << N) - 1);
            Arrays.fill(row, (1 << N) - 1);
            // 初始化九宫格内数字的使用情况
            for (int[] rows : cell) {
                Arrays.fill(rows, (1 << N) - 1);
            }
            // 数独数组
            int[][] grid = new int[N][N];
            // 需要填充的数字数量
            int key = N * N;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int index = i * N + j;
                    char c = line.charAt(index);
                    int num = c == '.' ? 0 : c - '0';
                    // 把当前数字填到表中
                    grid[i][j] = num;
                    if (num > 0) {
                        int bit = num - 1;
                        // 标记当前数字在第 i 行已经使用
                        row[i] -= 1 << bit;
                        // 标记当前数字在第 j 列已经使用
                        col[j] -= 1 << bit;
                        // 标记数字在该单元格已经使用
                        cell[i / 3][j / 3] -= 1 << bit;
                        // 需要填充的数字 - 1
                        key--;
                    }
                }
            }
            dfs(key, grid, col, row, cell);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(grid[i][j]);
                }
            }
            System.out.println();
        }
    }


    private static boolean dfs(int key, int[][] grid, int[] col, int[] row, int[][] cell) {
        // 填充完毕
        if (key <= 0) return true;
        // 找到可以填的数组最少的单元格
        int x = -1, y = -1, minv = 10;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0) {
                    // 求出当前位置能够填的数字集合的二进制表示
                    int nums = row[i] & col[j] & cell[i / 3][j / 3];
                    // 计算能填的数字的数量
                    int numSize = cnt[nums];
                    if (numSize < minv) {
                        minv = numSize;
                        x = i;
                        y = j;
                    }
                }
            }
        }
        if (x == -1) return true;
        // 尝试所有可以填的数字
        int nums = row[x] & col[y] & cell[x / 3][y / 3];
        // 遍历每一位数
        for (int i = nums; i != 0; i -= lowbit(i)) {
            // 获取填入的数字 (0-8)
            int bit = lowbit(i);
            int num = log2[bit] + 1;
            grid[x][y] = num;
            row[x] -= bit;
            // 标记当前数字在第 j 列已经使用
            col[y] -= bit;
            // 标记数字在该单元格已经使用
            cell[x / 3][y / 3] -= bit;
            // 递归
            if (dfs(key - 1, grid, col, row, cell)) {
                return true;
            }
            // 回溯
            row[x] += bit;
            col[y] += bit;
            cell[x / 3][y / 3] += bit;
            grid[x][y] = 0;
        }
        return false;
    }

    /**
     * 计算二进制数最后一个 1 以及后面的 0 构成的数值
     * 例如 lowbit(01110100₂) = (100₂) = 4
     * 取对数后获得最后一位 1 所在的位置
     */
    private static int lowbit(int x) {
        return x & -x;
    }

}

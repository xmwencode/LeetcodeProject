package com.xm.acwing.improve.dp.digitaltrianglemodel;

import java.util.Scanner;

/**
 * 设有 N×N 的方格图，我们在其中的某些方格中填入正整数，而其它的方格中则放入数字0。如下图所示：
 * <p>
 * 2.gif
 * <p>
 * 某人从图中的左上角 A 出发，可以向下行走，也可以向右行走，直到到达右下角的 B 点。
 * <p>
 * 在走过的路上，他可以取走方格中的数（取走后的方格中将变为数字0）。
 * <p>
 * 此人从 A 点到 B 点共走了两次，试找出两条这样的路径，使得取得的数字和为最大。
 * <p>
 * 输入格式
 * 第一行为一个整数N，表示 N×N 的方格图。
 * <p>
 * 接下来的每行有三个整数，第一个为行号数，第二个为列号数，第三个为在该行、该列上所放的数。
 * <p>
 * 行和列编号从 1
 *  开始。
 * <p>
 * 一行“0 0 0”表示结束。
 * <p>
 * 输出格式
 * 输出一个整数，表示两条路径上取得的最大的和。
 * <p>
 * 数据范围
 * N≤10
 * <p>
 * 输入样例：
 * 8
 * 2 3 13
 * 2 6 6
 * 3 5 7
 * 4 4 14
 * 5 2 21
 * 5 6 4
 * 6 3 15
 * 7 2 14
 * 0 0 0
 * 输出样例：
 * 67
 */
// AcWing 1027. 方格取数
public class Main1027 {

    /**
     * 方法二：状态压缩优化
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // dp[i1, j1, i2, j2] 表示 A 走到 [i1, j1], B 走到 [i2, j2] 的最大数字和
        // => 从这里可以发现只有当 A 和 B 走相同步数时才会涉及到结果的更新，使用一个变量表示步数和
        // dp[k, i1, i2]: k = i1 + j1 = i2 + j2
        int[][][] dp = new int[2 * n + 2][n + 1][n + 1];
        int[][] w = new int[n + 1][n + 1];
        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (a == 0 && b == 0 && c == 0) {
                break;
            }
            w[a][b] = c;
        }
        for (int k = 2; k <= 2 * n; k ++) {
            for (int i1 = 1; i1 <= n; i1++) {
                for (int i2 = 1; i2 <= n; i2++) {
                    int j1 = k - i1, j2 = k - i2;
                    if (j1 >= 1 && j1 <= n && j2 >= 1 && j2 <= n) {
                        int t = w[i1][j1];
                        if (i1 != i2) t += w[i2][j2];
                        dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k - 1][i1 - 1][i2 - 1] + t);
                        dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k - 1][i1][i2 - 1] + t);
                        dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k - 1][i1 - 1][i2] + t);
                        dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k - 1][i1][i2] + t);
                    }
                }
            }
        }
        System.out.println(dp[2 * n][n][n]);
    }


    /**
     * 方法一：直接进行 dp
     */
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // dp[i1, j1, i2, j2] 表示 A 走到 [i1, j1], B 走到 [i2, j2] 的最大数字和
        int[][][][] dp = new int[n + 1][n + 1][n + 1][n + 1];
        int[][] w = new int[n + 1][n + 1];
        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (a == 0 && b == 0 && c == 0) {
                break;
            }
            w[a][b] = c;
        }
        for (int i1 = 1; i1 <= n; i1++) {
            for (int j1 = 1; j1 <= n; j1++) {
                for (int i2 = 1; i2 <= n; i2++) {
                    for (int j2 = 1; j2 <= n; j2++) {
                        dp[i1][j1][i2][j2] = Math.max(dp[i1][j1][i2][j2], dp[i1 - 1][j1][i2 - 1][j2]);
                        dp[i1][j1][i2][j2] = Math.max(dp[i1][j1][i2][j2], dp[i1][j1 - 1][i2 - 1][j2]);
                        dp[i1][j1][i2][j2] = Math.max(dp[i1][j1][i2][j2], dp[i1 - 1][j1][i2][j2 - 1]);
                        dp[i1][j1][i2][j2] = Math.max(dp[i1][j1][i2][j2], dp[i1][j1 - 1][i2][j2 - 1]);
                        if (i1 == i2 && j1 == j2) dp[i1][j1][i2][j2] += w[i1][j1];
                        else dp[i1][j1][i2][j2] += w[i1][j1] + w[i2][j2];
                    }
                }
            }
        }
        System.out.println(dp[n][n][n][n]);
    }

}

package com.xm.acwing.improve.dp.backpackmodel;

import java.util.Scanner;

public class Main6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dp = new int[m + 1];
        int[] q = new int[m + 1]; // 主队列，记录的是本次的结果
        int[] g = new int[m + 1]; // 辅助数组，记录的是上一个物品计算的最佳结果
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt(); // 当前物品体积
            int w = sc.nextInt(); // 当前物品价值
            int s = sc.nextInt(); // 当前物品数量
            // 将上一次计算的结果放入辅助数组中
            System.arraycopy(dp, 0, g, 0, q.length);
            // 枚举余数，即枚举到 v - 1
            for (int j = 0; j < v; j++) {
                // 初始化队列
                int head = 0, tail = -1;
                // 枚举对于同一个余数的状态转移过程: dp[0] -> dp[2] -> dp[4] ...
                // 即遍历：j, j+v, j+2v...（同余数容量）
                for (int k = j; k <= m; k += v) {
                    // 这是上一件物品在容量为 k 时的最佳方案
                    dp[k] = g[k];
                    // 将不在窗口范围的值弹出
                    // k: 当前正在计算的背包容量
                    // s * v: 这个物品最多能占用的体积
                    // q[] 里面存储的是容量限制
                    if (head <= tail && q[head] < k - s * v) {
                        // 假设当前我们处理到的物品体积和价值均为 2，数量为 3，而我们背包容量为 10。
                        // 当前计算到了 k = 9，s = 3，v = 2
                        // 那么当前 dp[9] 就可以由 dp[3]、dp[5]、dp[7] 转移
                        // 如果此时 q[head] 为 1，dp[9] 因为数量限制 3，所以不能从 dp[1] 转移过来
                        head++;
                    }
                    // 用当前值更新队尾值最大值，维护单调递减队列
                    // 如果把容量上限从 q[tail] 换成 j，最大价值是否能够增加？
                    if (head <= tail) {
                        // (k - q[head]) / v 计算的是当前选择数量
                        // dp[i] = max(dp[i], dp[j - s * v] + s * w)
                        dp[k] = Math.max(dp[k], g[q[head]] + (k - q[head]) / v * w);
                    }
                    // 当前值比对尾值更优，队尾元素没必要存在，队尾出队
                    while (head <= tail && g[q[tail]] - (q[tail] - j) / v * w <= g[k] - (k - j) / v * w) {
                        tail--;
                    }
                    // 新下标入队
                    q[++tail] = k;
                }
            }
        }
        System.out.println(dp[m]);
    }
}

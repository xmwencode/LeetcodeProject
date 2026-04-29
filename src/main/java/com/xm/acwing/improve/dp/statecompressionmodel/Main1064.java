package com.xm.acwing.improve.dp.statecompressionmodel;

import java.util.*;

public class Main1064 {

    static int N = 12, M = 1 << 10, K = 110;
    static int n, m;
    // dp[i, j, s]: 前 i 行已经放了 j 个国王，且第 i 行的摆放状态为 s 的所有方案的集合
    static long[][][] dp = new long[N][K][M];
    // 存储所有合法状态（同行无相邻国王）
    static List<Integer> state = new ArrayList<>();
    // 存合法状态能够走到的所有其他合法状态，是双向的，即 a <-> b
    // 即存储状态a的所有合法前驱状态b（上一行）
    static Map<Integer, List<Integer>> map = new LinkedHashMap<>();
    // 记录每个状态的国王数量（二进制1的个数）
    static int[] cnt = new int[M];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        // 1. 预处理：筛选所有【同行合法】的状态（无相邻1）
        for (int i = 0; i < 1 << n; i++) {
            if (check(i)) {
                state.add(i);
                cnt[i] = count(i);
            }
        }
        // 2. 预处理：筛选【两行之间合法】的状态（上下、对角线无国王）
        for (int a : state) {
            for (int b : state) {
                // 条件1：正上下无国王 (a & b) = 0
                // 条件2：对角线无国王 (a | b) 无相邻1
                if ((a & b) == 0 && check(a | b)) {
                    // 如果这个数 a 还没有存过数，那么就新建一个列表存
                    map.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
                }
            }
        }

        // 3. DP初始化：前0行放0个国王，状态为0，方案数=1
        dp[0][0][0] = 1;

        // 4. DP状态转移
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                // 枚举当前行的合法状态 a
                for (int a : state) {
                    // 当前行的国王数
                    int c = cnt[a];
                    // 当前国王数量不够
                    if (c > j) continue;
                    // 枚举上一行的合法状态 b
                    for (int b : map.getOrDefault(a, new ArrayList<>())) {
                        dp[i][j][a] += dp[i - 1][j - c][b];
                    }
                }
            }
        }
        // 计算所有合法状态的方案数和
        long res = 0;
        for (int s : state) {
            res += dp[n][m][s];
        }
        System.out.println(res);
    }

    /**
     * 判断数字里是否存在两个相同的 1，存在则不合法
     */
    private static boolean check(int state) {
        for (int i = 0; i < n; i++) {
            if ((state >> i & 1) == 1 && (state >> (i + 1) & 1) == 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 统计 state 有多少位是 1
     */
    private static int count(int state) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            if ((state >> i & 1) == 1) {
                res++;
            }
        }
        return res;
    }
}

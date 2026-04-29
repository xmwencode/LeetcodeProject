package com.xm.acwing.improve.dp.statecompressionmodel;

import java.util.*;

public class Main327 {

    static int N = 15, M = 1 << 15, mod = (int)1e8;
    static int n, m;
    // dp[i, j]: 种植前 i 行，且第 i 行的状态为 j 的所有方案的集合
    static long[][] dp = new long[N][M];
    // 土地表示
    static int[][] g = new int[N][N];
    // 存储所有合法状态（同行无相邻玉米）
    static List<Integer> state = new ArrayList<>();
    // 存合法状态能够走到的所有其他合法状态，是双向的，即 a <-> b
    // 即存储状态a的所有合法前驱状态b（上一行）
    static Map<Integer, List<Integer>> map = new LinkedHashMap<>();
    // 记录当前不育的土地状态
    static int[] mapState = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                g[i][j] = sc.nextInt();
            }
        }

        // 1. 预处理所有合法状态
        for (int s = 0; s < 1 << m; s++) {
            if (check(s)) {
                state.add(s);
            }
        }
        // 2. 预处理所有的上一个合法状态
        for (int a : state) {
            for (int b : state) {
                if ((a & b) == 0) {
                    map.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
                }
            }
        }
        // 3. 计算不良土地的状态表示
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum = (sum << 1) + g[i][j];
            }
            mapState[i] = sum;
        }
        // 全部都不种，初始化为 1
        dp[0][0] = 1;
        // 4. 动态规划
        for (int i = 1; i <= n + 1; i++) {
            for (int a : state) {
                // 当前状态存在不良土地，直接跳过
                if ((a & mapState[i]) != a) {
                    // 当前状态不合法，直接跳过
                    continue;
                }
                // 枚举上一层的合法状态
                for (int b : map.getOrDefault(a, new ArrayList<>())) {
                    dp[i][a] = (dp[i][a] + dp[i - 1][b]) % mod;
                }
            }
        }
        // 第 n + 1 层的第一个状态，刚好就是前面 n 层所有状态的集合
        /// 虚拟行状态 a = 0，满足两个关键条件：
        /// 土地合法：(0 & mapState[n+1]) == 0（永远成立，不种玉米永远合法）；
        /// 0 & 任意状态b = 0 → 虚拟行可以承接上一行所有合法状态。
        System.out.println(dp[n + 1][0]);
    }

    /**
     * 检查当前数字二进制是否有两个相邻的 1
     */
    private static boolean check(int state) {
        for (int i = 0; i < m - 1; i++) {
            if ((state >> i & 1) == 1 && (state >> (i + 1) & 1) == 1) {
                return false;
            }
        }
        return true;
    }
}

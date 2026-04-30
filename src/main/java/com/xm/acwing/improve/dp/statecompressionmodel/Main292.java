package com.xm.acwing.improve.dp.statecompressionmodel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main292 {

    static int n, m;
    static int N = 110, M = 12, K = 1 << 12;
    // 所有已经摆完前i行，且第i-1行的状态是j，第i行的状态是k的所有方案的最大值
    static int[][][] dp = new int[2][K][K];
    static List<Integer> states = new ArrayList<>();
    static int[] mapState = new int[N];
    static int[] cnt = new int[K];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        // 1. 初始化地图山地
        for (int i = 1; i <= n; i++) {
            String str = sc.next();
            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == 'H') {
                    mapState[i] |= 1 << j;
                }
            }
        }

        // 2. 预处理合法状态
        for (int i = 0; i < 1 << m; i++) {
            if (check(i)) {
                states.add(i);
                cnt[i] = count(i);
            }
        }

        // 3. 初始化DP：全部设为 负无穷
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < K; j++)
                for (int k = 0; k < K; k++)
                    dp[i][j][k] = -0x3f3f3f3f;

        // 4. 初始状态：第0行、第-1行都是空状态（0），这是合法起点
        dp[0][0][0] = 0;

        // 5. 状态转移
        for (int i = 1; i <= n; i++) {
            // 每次处理新行，清空当前滚动层为 负无穷
            for (int a = 0; a < K; a++)
                for (int b = 0; b < K; b++)
                    dp[i & 1][a][b] = -0x3f3f3f3f;

            // 遍历：上两行状态c | 上一行状态b | 当前行状态a
            for (int curr = 0; curr < states.size(); curr++) {
                int a = states.get(curr);
                // 当前行不能在山地
                if ((a & mapState[i]) != 0) continue;

                for (int last1 = 0; last1 < states.size(); last1++) {
                    int b = states.get(last1);
                    // 当前行与上一行 无冲突
                    if ((a & b) != 0) continue;

                    for (int last2 = 0; last2 < states.size(); last2++) {
                        int c = states.get(last2);
                        // 当前行与上两行、上一行与上两行 无冲突
                        if ((a & c) != 0 || (b & c) != 0) continue;

                        // 状态转移（只有可达状态才会更新）
                        dp[i & 1][b][a] = Math.max(dp[i & 1][b][a], dp[(i - 1) & 1][c][b] + cnt[a]);
                    }
                }
            }
        }

        // 6. 取最终答案
        int res = 0;
        for (int x : states)
            for (int y : states)
                res = Math.max(res, dp[n & 1][x][y]);

        System.out.println(res);
    }

    /**
     * 统计一个数字的二进制表示中 1 的数量
     */
    private static int count(int s) {
        int res = 0;
        while (s > 0) {
            res += s & 1;
            s >>= 1;
        }
        return res;
    }

    /**
     * 单行合法：无相邻、无间隔1个的炮兵
     */
    private static boolean check(int state) {
        return (state & (state << 1)) == 0 && (state & (state << 2)) == 0;
    }
}

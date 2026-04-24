package com.xm.acwing.improve.dp.longestascendingsubsequencemodel;

import java.util.Arrays;
import java.util.Scanner;

public class Main1012 {

    private static class Pair implements Comparable<Pair> {
        public int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.a != o.a) {
                return this.a - o.a;
            }
            return this.b - o.b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 如何定义上升？
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(sc.nextInt(), sc.nextInt());
        }
        // 从小到达排序
        Arrays.sort(pairs);
        // dp[i] 表示以第 i 对结尾的最长上升子序列
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // pairs[i].a >= pairs[j].a 可以省略，因为已经排序过了
                if (pairs[i].b >= pairs[j].b) { // 只要不相交即可，可以重复
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        System.out.println(res);
    }
}

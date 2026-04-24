package com.xm.acwing.improve.dp.longestascendingsubsequencemodel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1010 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        int[] w = new int[1010];
        while (sc.hasNextInt()) {
            w[n++] = sc.nextInt();
        }
        // 最多拦截多少导弹：求最长不严格下降子序列
        // 需要多少套系统：Dilworth 定理 => 求最长严格上升子序列
        // Dilworth 定理：一个序列的最少不上升子序列划分个数 = 该序列的最长严格上升子序列长度
        int[][] dp = new int[n][2];
        int max = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            dp[i][0] = dp[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (w[j] >= w[i]) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
                } else {
                    dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
                }
            }
            max = Math.max(max, dp[i][0]);
            cnt = Math.max(cnt, dp[i][1]);
        }
        System.out.println(max);
        System.out.println(cnt);
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 最多拦截多少导弹：求最长下降子序列
        int n = 0;
        int[] w = new int[1010];
        while (sc.hasNextInt()) {
            w[n++] = sc.nextInt();
        }
        int[] dp = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (w[j] >= w[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
        // 需要多少套系统：贪心
        // 如果现有的子序列都小于当前的数，就新建一套系统进行拦截
        // 记录当前所有系统的末尾值
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // 标记现有系统能否满足需求
            boolean flag = false;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) >= w[i]) {
                    flag = true;
                    list.set(j, w[i]);
                    break;
                }
            }
            if (!flag) {
                list.add(w[i]);
            }
        }
        System.out.println(list.size());
    }
}

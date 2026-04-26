package com.xm.acwing.improve.dp.backpackmodel;

import java.util.Arrays;
import java.util.Scanner;

public class Main532 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] w = new int[n];
            for (int i = 0; i < n; i++) {
                w[i] = sc.nextInt();
            }
            Arrays.sort(w);
            int maxv = w[n - 1], res = 0;
            int[] dp = new int[maxv + 1];
            dp[0] = 1;
            for (int i = 0; i < n; i++) {
                if (dp[w[i]] == 0) {
                    res++;
                    for (int j = w[i]; j <= maxv; j++) {
                        dp[j] += dp[j - w[i]];
                    }
                }
            }
            System.out.println(res);
        }
    }
}

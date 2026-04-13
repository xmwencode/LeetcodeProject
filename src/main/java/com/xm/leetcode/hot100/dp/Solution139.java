package com.xm.leetcode.hot100.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        int maxLen = words.stream().mapToInt(String::length).max().orElse(0);
        int n = s.length();
        // dp[i]: s 前 i 个字母能否用字典列表表示
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= Math.max(0, i - maxLen); j--) {
                if (dp[j] && words.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
package leetcode.hot100;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int m = wordDict.stream().mapToInt(String::length).max().orElse(0);
        Set<String> words = new HashSet<>(wordDict);
        // dp[i]: s 中前 i 个字符是否能分成在 wordDict 中的若干段
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            // 将 0~i 分成 0~j 和 j+1~i
            for (int j = i - 1; j >= Math.max(i - m, 0); j--) {
                if (dp[j] && words.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
package com.xm.leetcode.hot100.dp;

class Solution5 {


    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        // dp[i, j]: s[i .. j] 是否是回文字串
        boolean[][] dp = new boolean[s.length()][s.length()];
        int start = 0, maxLen = 1;
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            dp[i][i] = true;
        }
        // 区间DP
        for (int len = 2; len <= str.length; len++) {
            for (int i = 0; i + len - 1 < str.length; i++) {
                int j = len + i - 1;
                if (str[i] != str[j]) {
                    // 当前字符串不相等，直接判负
                    dp[i][j] = false;
                } else {
                    // 根据内部字串得到
                    dp[i][j] = len < 4 || dp[i + 1][j - 1];
                }
                if (dp[i][j] && len > maxLen) {
                    maxLen = len;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    public String longestPalindrome2(String s) {
        char[] str = s.toCharArray();
        String res = "";
        for (int i = 0; i < str.length; i++) {
            // 1. 字串长度为奇数
            int l = i, r = i;
            while (l >= 0 && r < str.length && str[l] == str[r]) {
                l--;
                r++;
            }
            if (r - l - 1 > res.length()) {
                res = s.substring(l + 1, r);
            }
            // 2. 字符长度为偶数
            l = i;
            r = i + 1;
            while (l >= 0 && r < str.length && str[l] == str[r]) {
                l--;
                r++;
            }
            if (r - l - 1 > res.length()) {
                res = s.substring(l + 1, r);
            }
        }
        return res;
    }
}
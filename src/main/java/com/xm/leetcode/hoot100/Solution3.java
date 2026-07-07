package com.xm.leetcode.hoot100;

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        // 记录每一个字符出现的次数
        int[] cnt = new int[200];
        for (int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cnt[c]++;
            while (cnt[c] > 1) {
                cnt[s.charAt(j)]--;
                j++;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}
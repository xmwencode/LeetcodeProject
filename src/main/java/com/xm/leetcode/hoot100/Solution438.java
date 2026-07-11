package com.xm.leetcode.hoot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        // 存储 p 的每个字符以及出现的次数
        int[] pCnt = new int[26];
        // 存储 s 当前窗口内的每个字符以及出现的次数
        int[] sCnt = new int[26];
        for (char c : p.toCharArray()) {
            pCnt[c - 'a']++;
        }
        List<Integer> ans = new ArrayList<>();
        int m = p.length();
        int n = s.length();
        for (int right = 0; right < n; right++) {
            // 右端点字符进入滑动窗口
            sCnt[s.charAt(right) - 'a']++;
            int left = right - m + 1;
            if (left < 0) continue;
            if (Arrays.equals(pCnt, sCnt)) {
                ans.add(left);
            }
            // 左端点出滑动窗口
            sCnt[s.charAt(left) - 'a']--;
        }

        return ans;
    }
}
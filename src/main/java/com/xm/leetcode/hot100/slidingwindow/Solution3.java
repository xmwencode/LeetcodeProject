package com.xm.leetcode.hot100.slidingwindow;

import java.util.HashMap;
import java.util.Map;

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int[] cnt = new int[128];
        int j = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            cnt[c]++;
            while (cnt[c] > 1) {
                cnt[s.charAt(j++)]--;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.get(c) > 1) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
package com.xm.leetcode.hot100.sonstring;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution76 {
    public String minWindow(String s, String t) {
        // 存储 t 中字符的出现次数
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.merge(c, 1, Integer::sum);
        }
        // 存储需要的字符种类
        int need = tMap.size();
        // 存储 s 中字符出现的次数
        Map<Character, Integer> sMap = new HashMap<>();
        // 存储目前已足够的字符种类
        int count = 0;
        // 最小覆盖字串长度
        int minLen = Integer.MAX_VALUE;
        // 最小覆盖字串起始位置
        int start = 0;
        // 存储左指针
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            // 加入字符到集合中
            sMap.merge(c, 1, Integer::sum);
            // 如果该字符达到了阈值，目前已足够的字符种类 + 1
            if (Objects.equals(sMap.getOrDefault(c, 0), tMap.getOrDefault(c, 0))) {
                count++;
            }
            // 如果达到了需要的所有阈值，左指针压缩
            while (count >= need) {
                if (minLen > right - left) {
                    start = left;
                    minLen = right - left + 1;
                }
                char leftChar = s.charAt(left);
                sMap.merge(leftChar, -1, Integer::sum);
                if (sMap.getOrDefault(leftChar, 0) < tMap.getOrDefault(leftChar, 0)) {
                    count--;
                }
                left++;
            }
        }
        if (minLen == Integer.MAX_VALUE) return "";
        return s.substring(start, start + minLen);
    }
}
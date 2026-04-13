package com.xm.leetcode.hot100.slidingwindow;

import java.util.*;

class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            pMap.merge(c, 1, Integer::sum);
        }
        List<Integer> res = new ArrayList<>();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            sMap.merge(c, 1, Integer::sum);
            while(sMap.getOrDefault(c, 0) > pMap.getOrDefault(c, 0)) {
                sMap.merge(s.charAt(left), -1, Integer::sum);
                left ++ ;
            }
            if (right - left + 1 == p.length()) {
                res.add(left);
            }
        }
        return res;
    }
}
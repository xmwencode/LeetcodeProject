package com.xm.leetcode.hot100.hash;

import java.util.*;

class Solution128 {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (Integer s : set) {
            // 如果不是开头，直接跳过
            if (set.contains(s - 1)) {
                continue;
            }
            int ed = s;
            while(set.contains(ed)) {
                ed ++ ;
            }
            res = Math.max(res, ed - s);
        }
        return res;
    }
}
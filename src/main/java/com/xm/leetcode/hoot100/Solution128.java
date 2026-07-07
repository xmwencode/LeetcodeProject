package com.xm.leetcode.hoot100;

import java.util.HashSet;
import java.util.Set;

class Solution128 {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (Integer num : nums) {
            set.add(num);
        }
        for (Integer x : set) {
            if (set.contains(x - 1)) {
                // 说明当前数字不是起点
                continue;
            }
            int y = x + 1;
            while (set.contains(y)) y++;
            ans = Math.max(ans, y - x);
        }
        return ans;
    }
}
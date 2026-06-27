package com.xm.leetcode.everyday;

import java.util.HashMap;
import java.util.Map;

class Solution3020 {
    public int maximumLength(int[] nums) {
        // O(NlogN) 的时间复杂度
        Map<Long, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            cnt.merge((long) x, 1, Integer::sum);
        }
        // 去除 1 的个数
        Integer cnt1 = cnt.remove(1L);
        // 保证答案是奇数，奇数不变，偶数减一
        int ans = cnt1 != null ? (cnt1 - 1) | 1 : 0;
        // 寻找符合条件的数组
        for (long x : cnt.keySet()) {
            int res = 0;
            while(cnt.getOrDefault(x, 0) >= 2) {
                res += 2;
                x *= x;
            }
            ans = Math.max(ans, res + (cnt.containsKey(x) ? 1 : -1));
        }
        return ans;
    }
}
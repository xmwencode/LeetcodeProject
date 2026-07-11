package com.xm.leetcode.hoot100;

import java.util.HashMap;
import java.util.Map;

class Solution560 {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;
        // 计算前缀和（不包括当前数）
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + nums[i];
        }
        // 记录前缀和为 m 的数组的个数
        Map<Integer, Integer> map = new HashMap<>(n + 1);
        // si - sj = k 符合条件的即为和为 k 的子数组
        for (int si : s) {
            // 查找前面有没有出现过 sj
            ans += map.getOrDefault(si - k, 0);
            // 将当前前缀和加入到 map 中
            map.merge(si, 1, Integer::sum);
        }

        return ans;
    }
}
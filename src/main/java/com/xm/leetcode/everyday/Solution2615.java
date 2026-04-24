package com.xm.leetcode.everyday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution2615 {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] res = new long[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        for (List<Integer> idxList : map.values()) {
            int m = idxList.size();
            if (m == 1) {
                // 只有一个元素，距离和为 0，无需处理
                continue;
            }
            // 计算前缀和
            long[] preSum = new long[m + 1];
            for (int i = 0; i < m; i++) {
                preSum[i + 1] = preSum[i] + idxList.get(i);
            }
            for (int i = 0; i < m; i++) {
                int target = idxList.get(i);
                // 左侧距离和 = target * 左侧元素个数 - 左侧下标总和（范围：dist[0] ~ dist[i-1]）
                long left = (long) target * i - preSum[i];
                // 右侧距离和 = 右侧下标总和 - target * 右侧元素个数（范围：dist[i+1] ~ dist[m-1]）
                long right = preSum[m] - preSum[i] - (long) target * (m - i);
                res[target] = left + right;
            }
        }

        return res;
    }
}
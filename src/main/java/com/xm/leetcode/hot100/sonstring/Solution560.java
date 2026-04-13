package com.xm.leetcode.hot100.sonstring;

import java.util.HashMap;
import java.util.Map;

class Solution560 {
    public int subarraySum(int[] nums, int k) {
        // 记录前缀和
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        // 记录子数组个数
        int res = 0;
        // 记录出现过的前缀和
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            // 到当前数字的前缀和: sum[i];
            // 目标区间和: k
            // 需要减去的前缀和: sum[i] - k;
            if (map.containsKey(sum[i] - k)) {
                // 以第 i 个数结尾的子数组，符合条件的个数
                res += map.get(sum[i] - k);
            }
            map.merge(sum[i], 1, Integer::sum);
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new Solution560().subarraySum(new int[]{1, 1, 1}, 2);
        System.out.println(res);
    }
}
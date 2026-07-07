package com.xm.leetcode.hoot100;

import java.util.HashMap;
import java.util.Map;

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        // key: 出现的数字 value: 对应的下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }
}
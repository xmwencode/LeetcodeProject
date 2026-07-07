package com.xm.leetcode.hoot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int x = nums[i];
            // 跳过重复数字
            if (i > 0 && x == nums[i - 1]) continue;
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int s = nums[i] + nums[j] + nums[k];
                // 双指针寻找符合条件的值
                if (s > 0) {
                    k--;
                } else if (s < 0) {
                    j++;
                } else {
                    int second = nums[j];
                    int third = nums[k];
                    // 符合条件
                    ans.add(s, List.of(nums[i], nums[j], nums[k]));
                    // 去重
                    while (j < k && nums[j] == second) j++;
                    while (k > j && nums[k] == third) k--;
                }
            }
        }
        return ans;
    }
}
package com.xm.leetcode.hot100.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int k = 0; k < n; k++) {
            // 根据 k 去重
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = n - 1;
            while (i < j) {
                int s = nums[k] + nums[i] + nums[j];
                if (s < 0) i++;
                else if (s > 0) j--;
                else {
                    res.add(List.of(nums[k], nums[i++], nums[j--]));
                    while (i < j && nums[i] == nums[i - 1]) i++;
                    while (i < j && nums[j] == nums[j + 1]) j--;
                }
            }
        }
        return res;
    }
}
package com.xm.leetcode.everyweek;

import java.util.ArrayList;
import java.util.List;

class Solution3912 {
    public List<Integer> findValidElements(int[] nums) {
        // 是否有效
        int n = nums.length;
        boolean[] visited = new boolean[n];
        // 记录从左侧开始遍历的最大值
        int leftMax = Integer.MIN_VALUE;
        // 记录从右侧开始遍历的最大值
        int rightMax = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            int x = nums[i];
            // 如果当前数比右侧最大值小，那不满足严格大于右侧数的条件
            visited[i] = x > rightMax;
            rightMax = Math.max(rightMax, x);
        }
        // 记录从左侧开始遍历的最大值
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            if (x > leftMax || visited[i]) {
                res.add(x);
            }
            leftMax = Math.max(leftMax, x);
        }
        return res;
    }
}
package com.xm.leetcode.hoot100;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        // 滑动窗口，存储的是下标
        Deque<Integer> queue = new ArrayDeque<>();
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            if (i > 0 && i - k + 1 > queue.getFirst()) queue.removeFirst();
            while (!queue.isEmpty() && nums[queue.getLast()] <= x) queue.removeLast();
            queue.add(i);
            if (i >= k - 1) ans[idx++] = nums[queue.getFirst()];
        }
        return ans;
    }
}
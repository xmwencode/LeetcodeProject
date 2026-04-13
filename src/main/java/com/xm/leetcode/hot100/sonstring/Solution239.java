package com.xm.leetcode.hot100.sonstring;

import java.util.*;

class Solution239 {
    // 单调栈
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 存储结果
        List<Integer> res = new ArrayList<>();
        // 滑动窗口: 存储的是数组下标，队头存储最大值所在下标
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            // 如果当前窗口超出 k 值，出队
            if (!queue.isEmpty() && queue.getFirst() < i - k + 1) queue.removeFirst();
            // 如果当前元素大于队尾的数组值，队尾出队
            while(!queue.isEmpty() && nums[queue.getLast()] <= x) {
                queue.removeLast();
            }
            // 当前元素下标入队
            queue.addLast(i);
            // 达到窗口容量，队头
            if (i >= k - 1) {
                res.add(nums[queue.getFirst()]);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
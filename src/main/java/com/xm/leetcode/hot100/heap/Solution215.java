package com.xm.leetcode.hot100.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution215 {
    PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

    public int findKthLargest(int[] nums, int k) {
        for (int num : nums) {
            queue.add(num);
        }
        int count = 0;
        while (++count < k) {
            queue.poll();
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;
        new Solution215().findKthLargest(nums, k);
    }
}
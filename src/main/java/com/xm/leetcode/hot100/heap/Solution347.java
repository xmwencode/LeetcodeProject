package com.xm.leetcode.hot100.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
                (Comparator.comparingInt(o -> -o.getValue()))
        );
        queue.addAll(map.entrySet());
        int[] res = new int[k];
        int count = 0;
        while (count < k) {
            res[count++] = queue.poll().getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        new Solution347().topKFrequent(nums, k);
    }
}
package leetcode.hot100;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                Comparator.comparingInt(Integer::intValue).reversed()
        );
        for (int num : nums) pq.offer(num);
        while (--k > 0) {
            pq.poll();
        }
        return pq.element();
    }
}
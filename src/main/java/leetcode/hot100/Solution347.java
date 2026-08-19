package leetcode.hot100;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                Map.Entry.<Integer, Integer>comparingByValue().reversed()
        );
        map.keySet().forEach(num -> {
            pq.offer(Map.entry(num, map.get(num)));
        });
        int[] res = new int[k];
        int index = 0;
        while (index < k && !pq.isEmpty()) {
            res[index++] = pq.poll().getKey();
        }
        return res;
    }
}
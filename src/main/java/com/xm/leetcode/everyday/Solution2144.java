package com.xm.leetcode.everyday;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution2144 {
    public int minimumCost1(int[] cost) {
        int sum = 0;
        Arrays.sort(cost);
        int flag = 0;
        for (int i = cost.length - 1; i >= 0; i--) {
            flag++;
            if (flag % 3 != 0) {
                sum += cost[i];
            }
        }
        return sum;
    }

    public int minimumCost(int[] cost) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int c : cost) {
            pq.offer(c);
        }
        int res = 0;
        while (!pq.isEmpty()) {
            res += pq.poll(); // 买最贵的
            if (!pq.isEmpty()) res += pq.poll(); // 买第二贵的
            if (!pq.isEmpty()) pq.poll(); // 第三件免费，跳过
        }
        return res;
    }
}
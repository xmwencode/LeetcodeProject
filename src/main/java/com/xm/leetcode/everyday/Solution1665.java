package com.xm.leetcode.everyday;

import java.util.Arrays;
import java.util.Comparator;

class Solution1665 {
    public int minimumEffort(int[][] tasks) {
        // tasks[i] = [actual[i], minimum[i]]
        Arrays.sort(tasks, Comparator.comparingInt(o -> (o[0] - o[1])));
        // 需要消耗的能量
        int sum = 0;
        // 最小初始能量
        int res = 0;
        for (int[] task : tasks) {
            // 完成该任务需要耗费的实际能量。
            int actual = task[0];
            // 开始该任务需要的最小能量能量。
            int minimum = task[1];
            // E0 - sum >= minimum
            res = Math.max(res, sum + minimum);
            sum += actual;
        }
        return res;
    }
}
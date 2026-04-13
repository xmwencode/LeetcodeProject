package com.xm.leetcode.hot100.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution56 {
    public int[][] merge(int[][] intervals) {
        // 将区间按 start 从小到大排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        // 贪心法: 每次都往末尾数组合并
        List<int[]> res = new ArrayList<>();
        // 记录末尾数组的终点值
        int ed = intervals[0][1];
        res.add(new int[]{intervals[0][0], intervals[0][1]});
        for (int[] interval : intervals) {
            int st = interval[0];
            if (st <= ed) {
                // 合并区间
                ed = Math.max(ed, interval[1]);
                res.get(res.size() - 1)[1] = ed;
            } else {
                // 新建区间
                res.add(new int[]{interval[0], interval[1]});
                // 更新末尾数组终点值
                ed = interval[1];
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
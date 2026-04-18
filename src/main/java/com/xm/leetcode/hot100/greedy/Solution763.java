package com.xm.leetcode.hot100.greedy;

import java.util.ArrayList;
import java.util.List;

class Solution763 {
    public List<Integer> partitionLabels(String s) {
        char[] str = s.toCharArray();
        int n = s.length();
        // 记录每个字母最后出现的位置
        int[] last = new int[26];
        for (int i = 0; i < n; i++) {
            last[str[i] - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int st = 0, ed = 0;
        for (int i = 0; i < n; i++) {
            ed = Math.max(ed, last[str[i] - 'a']);
            if (ed == i) { // 当前区间合并完毕
                res.add(ed - st + 1); // 保存区间长度
                st = ed + 1;
            }
        }
        return res;
    }
}
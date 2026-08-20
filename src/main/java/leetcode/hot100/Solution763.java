package leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution763 {
    public List<Integer> partitionLabels(String s) {
        // 存储每个字符的最终位置
        int[] ed = new int[26];
        Arrays.fill(ed, -1);
        for (int i = 0; i < s.length(); i++) {
            ed[s.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        // 目前分段能够到达的最远点（即满足条件的最近点）
        int maxPoint = Integer.MIN_VALUE;
        // 目前所在分段的起始点
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            maxPoint = Math.max(maxPoint, ed[idx]);
            if (i == maxPoint) {
                res.add(i - start + 1);
                start = i + 1;
                maxPoint = Integer.MIN_VALUE;
            }
        }
        return res;
    }
}
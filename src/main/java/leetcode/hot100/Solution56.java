package leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> list = new ArrayList<>();
        int pos = -1;
        for (int[] interval : intervals) {
            int st = interval[0], ed = interval[1];
            if (pos >= st) {
                pos = Math.max(pos, ed);
                list.set(list.size() - 1, new int[]{list.getLast()[0], pos});
            } else {
                int[] newList = new int[]{st, ed};
                list.addLast(newList);
                pos = ed;
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}
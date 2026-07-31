package leetcode.hot100;

import java.util.HashSet;
import java.util.Set;

class Solution128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int res = 0;
        for (int num : nums) {
            // 如果 num - 1 在 set 中说明 num 不是第一个数
            if (set.contains(num - 1)) continue;
            // 只考虑第一个数开头
            int begin = num;
            int cnt = 1;
            while (set.contains(begin + 1)) {
                begin++;
                set.remove(begin);
                cnt++;
            }
            res = Math.max(res, cnt);
        }
        return res;
    }
}
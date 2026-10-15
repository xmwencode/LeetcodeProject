package leetcode.ling.slidingwindow.variablelength;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution2831 {

    public int longestEqualSubarray(List<Integer> nums, int k) {
        if (nums.isEmpty()) return 0;
        int n = nums.size();
        int ans = 0;
        // 窗口中每个元素出现的下标
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> curList = map.computeIfAbsent(nums.get(i), key -> new ArrayList<>());
            curList.add(i - curList.size());
        }
        for (List<Integer> list : map.values()) {
            if (list.size() <= ans) continue;
            for (int l = 0, r = 0; r < list.size(); r++) {
                while (list.get(r) - list.get(l) > k) {
                    l++;
                }
                ans = Math.max(ans, r - l + 1);
            }
        }
        return ans;
    }

    public int longestEqualSubarray2(List<Integer> nums, int k) {
        if (nums.isEmpty()) return 0;
        int n = nums.size();
        int ans = 0;
        // 窗口中每个元素出现的下标
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums.get(i), key -> new ArrayList<>()).add(i);
        }
        for (List<Integer> list : map.values()) {
            for (int l = 0, r = 0; r < list.size(); r++) {
                int del = list.get(r) - list.get(l) - (r - l);
                while (del > k) {
                    l++;
                    del = list.get(r) - list.get(l) - (r - l);
                }
                ans = Math.max(ans, r - l + 1);
            }
        }

        return ans;
    }
}
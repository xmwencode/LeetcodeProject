package leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

class Solution560 {
    public int subarraySum(int[] nums, int k) {
        // 前缀和 + 两数之和
        int n = nums.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + nums[i];
        }
        // key: 前缀和  value: 数量
        Map<Integer, Integer> map = new HashMap<>(n + 1);
        int ans = 0;
        for (int sj : s) {
            ans += map.getOrDefault(sj - k, 0);
            map.merge(sj, 1, Integer::sum);
        }
        return ans;
    }
}
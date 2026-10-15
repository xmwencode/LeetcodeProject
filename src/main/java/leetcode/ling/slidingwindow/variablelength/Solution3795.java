package leetcode.ling.slidingwindow.variablelength;

import java.util.HashMap;
import java.util.Map;

class Solution3795 {
    public int minLength(int[] nums, int k) {
        int n = nums.length;
        int ans = n + 1;
        int win = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int l = 0, r = 0; r < n; r++) {
            if (map.getOrDefault(nums[r], 0) == 0) {
                win += nums[r];
            }
            map.merge(nums[r], 1, Integer::sum);
            while (win >= k) {
                ans = Math.min(ans, r - l + 1);
                // 压缩左指针
                Integer x = map.merge(nums[l], -1, Integer::sum);
                if (x == 0) win -= nums[l];
                l++;
            }
        }
        return ans > n ? -1 : ans;
    }
}
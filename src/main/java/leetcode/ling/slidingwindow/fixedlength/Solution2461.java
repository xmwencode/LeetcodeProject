package leetcode.ling.slidingwindow.fixedlength;

import java.util.HashMap;
import java.util.Map;

class Solution2461 {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        long sum = 0;
        Map<Integer, Integer> cnt = new HashMap<>();

        for (int i = 0; i < n; i++) {
            // 入端点
            sum += nums[i];
            cnt.merge(nums[i], 1, Integer::sum);
            int l = i - k + 1;
            if (l < 0) continue;

            // 计算
            if (cnt.size() == k) {
                ans = Math.max(ans, sum);
            }

            // 出端点
            sum -= nums[l];
            Integer c = cnt.merge(nums[l], -1, Integer::sum);
            if (c == 0) {
                cnt.remove(nums[l]);
            }
        }
        return ans;
    }
}
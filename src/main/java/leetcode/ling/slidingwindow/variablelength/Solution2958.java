package leetcode.ling.slidingwindow.variablelength;

import java.util.HashMap;
import java.util.Map;

class Solution2958 {
    public int maxSubarrayLength(int[] nums, int k) {
        // 不存在重复数字的子数组的数字之和
        int n = nums.length;
        // 记录窗口中字符数量
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        // 只滑动右端点
        for (int l = 0, r = 0; r < n; r++) {
            // 入端点
            map.merge(nums[r], 1, Integer::sum);
            // 窗口压缩
            while (map.get(nums[r]) > k) {
                map.merge(nums[l], -1, Integer::sum);
                l++; // 左指针右移
            }
            // 计算
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
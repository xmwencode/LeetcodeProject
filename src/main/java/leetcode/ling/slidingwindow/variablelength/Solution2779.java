package leetcode.ling.slidingwindow.variablelength;

import java.util.Arrays;

class Solution2779 {
    public int maximumBeauty(int[] nums, int k) {
        // 最长子序列，不要求连续
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        // 需要保证当前窗口中的【最大值 - 最小值 <= 2 * k】
        for (int l = 0, r = 0; r < n; r++) {
            while (nums[r] - nums[l] > 2 * k) {
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
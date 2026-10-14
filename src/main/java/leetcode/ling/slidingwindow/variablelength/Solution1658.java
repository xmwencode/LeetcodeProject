package leetcode.ling.slidingwindow.variablelength;

import java.util.Arrays;

class Solution1658 {
    public int minOperations(int[] nums, int x) {
        // 两端之和 = x => 中间滑动窗口 = sum - x
        long sum = Arrays.stream(nums).sum();
        long targetWin = sum - x;
        int n = nums.length;
        long win = 0;
        int ans = -1;
        for (int l = 0, r = 0; r < n; r++) {
            win += nums[r];
            while (l <= r && win > targetWin) {
                win -= nums[l];
                l++;
            }
            if (win == targetWin) {
                ans = Math.max(ans, r - l + 1);
            }
        }
        if (ans == -1) return -1;
        return n - ans;
    }
}
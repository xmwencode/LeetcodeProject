package leetcode.ling.slidingwindow.fixedlength;

import java.util.Arrays;

class Solution2090 {
    public int[] getAverages(int[] nums, int k) {
        // 窗口长度为 2 * k + 1
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        long sum = 0; // 窗口求和

        for (int i = 0; i < n; i++) {
            // 入端点
            sum += nums[i];
            if (i < 2 * k) continue;
            // 计算答案
            ans[i - k] = (int) (sum / (2 * k + 1));
            // 出端点
            sum -= nums[i - 2 * k];
        }
        return ans;
    }
}
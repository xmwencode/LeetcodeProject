package leetcode.ling.slidingwindow.fixedlength;

class Solution3652 {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        // 当前能获取的最大利润
        long total = 0, n = prices.length;
        for (int i = 0; i < n; i++) {
            total += (long) prices[i] * strategy[i];
        }
        long extra = 0;
        long maxExtra = 0; // 最大增量

        // 滑动窗口
        for (int i = 0; i < n; i++) {
            // 不存在右半段，无法进入
            if (i < k / 2) continue;
            // 1. 入端点
            extra -= (long) strategy[i - k / 2] * prices[i - k / 2];
            extra += (long) (1 - strategy[i]) * prices[i];
            int l = i - k + 1;
            if (l < 0) continue;

            // 2. 计算
            maxExtra = Math.max(maxExtra, extra);

            // 3. 出端点
            extra += (long) strategy[l] * prices[l];
            extra -= (long) (1 - strategy[l + k / 2]) * prices[l + k / 2];
        }
        return total + maxExtra;
    }
}
package leetcode.ling.slidingwindow.fixedlength;

import java.util.Arrays;

class Solution1423 {

    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        // s = Math.max(c[0, k-t] + c[t, n))
        int s = 0;
        for (int i = 0; i < k; i++) {
            s += cardPoints[i];
        }
        int ans = s;
        for (int i = 1; i <= k; i++) {
            s += cardPoints[n - i] - cardPoints[k - i];
            ans = Math.max(ans, s);
        }
        return ans;
    }

    /**
     * 逆向思维
     */
    public int maxScore2(int[] cardPoints, int k) {
        // 拿走 k 张最大，则留下来的 n - k 张连续且和最小
        int n = cardPoints.length;
        int windowLen = n - k;
        if (windowLen == 0) {
            return Arrays.stream(cardPoints).sum();
        }
        int total = Arrays.stream(cardPoints).sum();
        int minWindowSum = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            // 入端点
            sum += cardPoints[i];
            int l = i - windowLen + 1;
            if (l < 0) continue;
            // 计算
            minWindowSum = Math.min(minWindowSum, sum);
            // 出端点
            sum -= cardPoints[l];
        }
        return total - minWindowSum;
    }
}
package leetcode.ling.slidingwindow.fixedlength;

import java.util.Arrays;

class Solution3679 {

    /**
     * 贪心 + 滑动窗口
     */
    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        int n = arrivals.length;
        int ans = 0;
        int maxValue = Arrays.stream(arrivals).max().orElse(0);
        int[] cnt = new int[maxValue + 1];

        for (int i = 0; i < n; i++) {
            // 入端点
            if (cnt[arrivals[i]] == m) {
                // 计算 越晚丢弃效果越好，丢弃后当前位置置零
                ans++;
                arrivals[i] = 0;
            } else {
                cnt[arrivals[i]]++;
            }

            int l = i - w + 1;
            if (l < 0) continue;
            // 出端点
            cnt[arrivals[l]]--;
        }
        return ans;
    }
}
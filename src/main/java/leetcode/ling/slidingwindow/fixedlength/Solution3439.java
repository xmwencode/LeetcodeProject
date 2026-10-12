package leetcode.ling.slidingwindow.fixedlength;

class Solution3439 {

    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        // 合并相邻的 k 个会议到上一个会议，使得与下一个会议的开始时间差最大
        // => 合并连续的 k + 1 个空闲时间段，使得和最大
        int n = startTime.length;
        // 记录初始的空闲时间段
        int[] a = new int[n + 2];
        a[0] = startTime[0];

        // 会议：0, [29, 37], [49, 54], 64
        for (int i = 0; i < n - 1; i++) {
            a[i + 1] = startTime[i + 1] - endTime[i];
        }
        a[n] = eventTime - endTime[n - 1];
        int win = 0;
        int ans = 0;
        for (int i = 0; i < n + 1; i++) {
            win += a[i];
            // 不管窗口够不够长，先更新答案
            ans = Math.max(ans, win);
            int l = i - k;
            if (l < 0) continue;
            win -= a[l];
        }
        return ans;
    }
}
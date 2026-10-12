package leetcode.ling.slidingwindow.fixedlength;

class Solution1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        // 第 i 分钟顾客满意：grumpy[i] = 0
        // sum = customers[i] - customers[i - 1]
        int n = customers.length;
        int sum = 0;
        // 记录不生气时的顾客和
        int s0 = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                s0 += customers[i];
            }
        }
        // 不生气的和与一段长为 minutes 的窗口的区间生气的和
        int ans = sum;
        // 记录生气时的 minutes 窗口区间和
        for (int i = 0; i < n; i++) {
            // 入端点
            if (grumpy[i] == 1) {
                sum += customers[i];
            }
            int l = i - minutes + 1;
            if (l < 0) {
                continue;
            }
            // 计算
            ans = Math.max(ans, sum + s0);

            // 出端点
            if (grumpy[l] == 1) {
                sum -= customers[l];
            }
        }
        return ans;
    }
}
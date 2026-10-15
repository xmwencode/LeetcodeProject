package leetcode.ling.slidingwindow.variablelength;

class Solution2555 {
    public int maximizeWin(int[] prizePositions, int k) {
        // 定义 mx[i] 为 i 左边的一条线段能够覆盖的最多奖品数量
        int n = prizePositions.length;
        if (k * 2 + 1 >= prizePositions[n - 1] - prizePositions[0]) {
            return n;
        }
        int[] mx = new int[n + 1];
        // 两条线段一共的奖品数量
        int ans = 0;
        for (int l = 0, r = 0; r < n; r++) {
            while (prizePositions[r] - prizePositions[l] > k) {
                l++;
            }
            // 单线段窗口中的奖品数量 = r - l + 1
            mx[r + 1] = Math.max(mx[r], r - l + 1);
            ans = Math.max(ans, mx[l] + r - l + 1);
        }
        return ans;
    }
}
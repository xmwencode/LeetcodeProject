package leetcode.ling.slidingwindow.variablelength;

class Solution2106 {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        // 求出向左最远能够到达的位置 fruits[l][0]
        int l = lowerBound(fruits, startPos - k);
        int r = l;
        // 求出 l 到 startPos 之间的水果和
        int win = 0;
        for (; r < n && fruits[r][0] <= startPos; r++) {
            win += fruits[r][1];
        }
        // 从此刻开始不断将窗口向右移，窗口需要至少满足一个条件：
        // 1.(fruits[r] - startPos) * 2 + (startPos - fruits[l]) <= k
        //   先往右走，再往左走
        // 2.(fruits[r] - startPos) + (startPos - fruits[l]) * 2 <= k
        //   先往左走，再往右走
        int ans = win;
        // 右指针右移
        for (; r < n && fruits[r][0] <= startPos + k; r++) {
            win += fruits[r][1];
            // 压缩左指针
            while ((fruits[r][0] - startPos) * 2 + (startPos - fruits[l][0]) > k
                    && (fruits[r][0] - startPos) + (startPos - fruits[l][0]) * 2 > k) {
                win -= fruits[l++][1];
            }
            ans = Math.max(ans, win);
        }
        return ans;
    }

    private int lowerBound(int[][] fruits, int target) {
        int n = fruits.length;
        // 求nums[] 中 > target 的最左边的数
        int l = 0, r = n;
        // [l, r)
        while (l < r) {
            // fruits[l][0] < target
            // fruits[r][0] >= target
            int mid = l + (r - l) / 2;
            if (fruits[mid][0] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }


}
package leetcode.ling.slidingwindow.variablelength;

import java.util.Arrays;
import java.util.Comparator;

class Solution2271 {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        int ans = 0;
        int win = 0;
        int left = 0;
        // 贪心：以左端点排序 => 只考虑右端点
        Arrays.sort(tiles, Comparator.comparingInt(a -> a[0]));
        for (int[] tile : tiles) {
            int tl = tile[0];
            int tr = tile[1];
            win += tr - tl + 1;
            // 毯子的左端点
            int carpetLeft = tr - carpetLen + 1;
            while (tiles[left][1] < carpetLeft) {
                win -= tiles[left][1] - tiles[left][0] + 1;
                left++;
            }
            // tiles[left] 中小于 carpetLeft 的这部分不在窗口中
            ans = Math.max(ans, win - Math.max(0, carpetLeft - tiles[left][0]));
        }
        return ans;
    }
}
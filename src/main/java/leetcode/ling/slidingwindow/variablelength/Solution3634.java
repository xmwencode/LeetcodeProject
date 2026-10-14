package leetcode.ling.slidingwindow.variablelength;

import java.util.Arrays;

class Solution3634 {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        int maxWin = 0;
        // [1, 2, 3, 4, 6, 8]
        // 移除的最少 => 剩余的最多
        Arrays.sort(nums);
        for (int l = 0, r = 0; r < n; r++) {
            while ((long) nums[l] * k < (long) nums[r]) {
                l++;
            }
            maxWin = Math.max(maxWin, r - l + 1);
        }
        return n - maxWin;
    }
}
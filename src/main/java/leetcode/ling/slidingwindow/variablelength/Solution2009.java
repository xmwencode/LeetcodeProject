package leetcode.ling.slidingwindow.variablelength;

import java.util.Arrays;

class Solution2009 {

    public int minOperations(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        // 原地去重
        int m = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[m++] = nums[i];
            }
        }
        // 【1, 2, 4, 6, 7 | 2, 4】
        // 窗口保证 nums[r] - nums[l] < n
        int ans = 0;
        for (int l = 0, r = 0; r < m; r++) {
            while (nums[r] - nums[l] >= n) {
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return n - ans;
    }
}
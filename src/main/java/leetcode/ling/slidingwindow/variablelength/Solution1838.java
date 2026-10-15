package leetcode.ling.slidingwindow.variablelength;

import java.util.Arrays;

class Solution1838 {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        long op = 0;
        int ans = 0;
        Arrays.sort(nums);
        for (int l = 0, r = 0; r < n; r++) {
            if (r > 0) op += (long) (nums[r] - nums[r - 1]) * (r - l);
            while (op > k) {
                op -= nums[r] - nums[l];
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
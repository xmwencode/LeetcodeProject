package leetcode.ling.slidingwindow.variablelength;

class Solution2875 {
    public int minSizeSubarray(int[] nums, int target) {
        long total = 0;
        for (int num : nums) {
            total += num;
        }
        long win = 0;
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int l = 0, r = 0; r < 2 * n; r++) {
            win += nums[r % n];
            while (win > target % total) {
                win -= nums[l % n];
                l++;
            }
            if (win == target % total) {
                ans = Math.min(ans, r - l + 1);
            }
        }
        if (ans == Integer.MAX_VALUE) return -1;
        return ans + (int) (target / total) * n;
    }
}
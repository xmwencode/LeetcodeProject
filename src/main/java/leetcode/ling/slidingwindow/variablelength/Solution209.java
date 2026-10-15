package leetcode.ling.slidingwindow.variablelength;

class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        // 窗口和
        int win = 0;
        int n = nums.length;
        int ans = n + 1;
        for (int l = 0, r = 0; r < n; r++) {
            win += nums[r];
            // 压缩左指针
            while (win >= target) {
                ans = Math.min(ans, r - l + 1);
                win -= nums[l++];
            }
        }
        return ans <= n ? ans : 0;
    }
}
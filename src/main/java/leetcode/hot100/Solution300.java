package leetcode.hot100;

class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // dp[i]: 前 i 个数中以第 i 个数结尾的最长递增子序列的最长长度
        int[] dp = new int[n + 1];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i] + 1);
        }
        return res;
    }
}
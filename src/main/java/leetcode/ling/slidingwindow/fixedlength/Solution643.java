package leetcode.ling.slidingwindow.fixedlength;

class Solution643 {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double ans = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            // 入端点
            sum += nums[i];
            int left = i - k + 1;
            if (left < 0) continue;

            // 更新答案
            ans = Math.max(ans, sum);

            // 出端点
            sum -= nums[left];
        }
        return ans / k;
    }
}
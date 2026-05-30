package com.xm.leetcode.everyday;

class Solution3300 {
    public int minElement(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int num : nums) {
            int x = num;
            int sum = 0;
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }
            ans = Math.min(ans, sum);
        }
        return ans;
    }
}
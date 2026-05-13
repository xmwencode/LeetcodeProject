package com.xm.leetcode.everyday;

class Solution1674 {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] diff = new int[limit * 2 + 2];
        for (int i = 0; i < n / 2; i++) {
            int x = nums[i];
            int y = nums[n - 1 - i];
            int l = Math.min(x, y) + 1;
            int r = Math.max(x, y) + limit;
            // [2, l - 1] += 2
            diff[2] += 2;
            diff[l] -= 2;
            // [l, r] += 1
            diff[l] ++;
            diff[r + 1] --;
            // x + y = k 操作 0 次，从 [l, r] 中删去
            diff[x + y]--;
            diff[x + y + 1]++;
            // [r + 1, limit * 2] += 2
            diff[r + 1] += 2;
            diff[limit * 2 + 1] -= 2;
        }
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 2; i <= limit * 2; i++) {
            sum += diff[i];
            ans = Math.min(ans, sum);
        }
        return ans;
    }
}
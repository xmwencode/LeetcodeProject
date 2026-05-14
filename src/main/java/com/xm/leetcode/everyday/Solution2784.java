package com.xm.leetcode.everyday;

class Solution2784 {

    public boolean isGood(int[] nums) {
        /**
         * 数组的最大值 = n-1
         * 数字 1 ~ n-2 中每个数字恰好出现 1 次
         * 最大值 n-1 恰好出现 2 次
         * 没有任何其他多余数字
         */
        int[] cnt = new int[210];
        int n = nums.length;
        int maxv = Integer.MIN_VALUE;
        // 最大值为 (n - 1) 且出现两次，其他只出现一次
        for (int num : nums) {
            cnt[num]++;
            maxv = Math.max(maxv, num);
        }
        for (int i = 1; i < n - 1; i++) {
            if (cnt[i] != 1) return false;
        }
        return cnt[n - 1] == 2 && maxv == n - 1;
    }

}
package com.xm.leetcode.everyday;

class Solution2078 {

    public int maxDistance(int[] colors) {
        // 如果 color[0] != color[n - 1]; 答案直接就是 n - 1;
        int n = colors.length;
        if (colors[0] != colors[n - 1]) {
            return n - 1;
        }
        // c: color[0] == color[n - 1]
        int c = colors[0];
        // 设最大距离来自 i 和 j 那么两个颜色都不可能等于 c
        // 找到最左边第一个不等于 c 的数与右边第一个不等于 c 的数
        int l = 1, r = n - 2;
        while (c == colors[l]) l++;
        while (c == colors[r]) r--;
        return Math.max(l, n - l - 1);
    }

    public int maxDistance2(int[] colors) {
        int l = 0, r = colors.length - 1;
        return dfs(colors, l, r);
    }

    // 超时
    public int dfs(int[] nums, int l, int r) {
        if (l >= r) return 0;
        if (nums[l] != nums[r]) return r - l;
        // 如果遇到两个相等的颜色，可以移动左指针，也可以移动右指针
        // 移动左指针
        int left = dfs(nums, l + 1, r);
        // 移动右指针
        int right = dfs(nums, l, r - 1);
        return Math.max(left, right);
    }

}
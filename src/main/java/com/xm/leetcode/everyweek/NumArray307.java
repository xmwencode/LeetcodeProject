package com.xm.leetcode.everyweek;

/**
 * 树状数组
 * 给你一个数组，如何快速地计算任意一段连续子数组的元素和？
 * 可以使用前缀和 s[r] - s[l - 1] 快速计算
 * 但是，如果还可以修改数组中的元素呢？
 * 比如我把下标为 1 的元素修改了，由于所有前缀都包含下标 1，那么就需要更新所有前缀的元素和，更新操作就需要 O(n) 的时间
 * 能否把任意前缀拆分成若干个关键区间，使得更新操作也只会更新若干个关键区间？
 * 使用【树状数组】
 */
class NumArray307 {

    int[] tree; // 下标从 1 开始
    int[] nums;

    public NumArray307(int[] nums) {
        int n = nums.length;
        this.nums = new int[n]; // 使 update 中算出的 delta = nums[i]
        tree = new int[n + 1];
        for (int i = 0; i < n; i++) {
            update(i, nums[i]);
        }
    }

    public void update(int index, int val) {
        // delta: 需要增加的值
        int delta = val - nums[index];
        nums[index] = val;
        for (int i = index + 1; i < tree.length; i += i & (-i)) {
            tree[i] += delta;
        }
    }

    private int sum(int i) {
        int res = 0;
        for (; i > 0; i -= i & (-i)) {
            res += tree[i];
        }
        return res;
    }

    public int sumRange(int left, int right) {
        return sum(right + 1) - sum(left);
    }
}
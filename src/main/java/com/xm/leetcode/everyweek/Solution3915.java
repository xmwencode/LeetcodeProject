package com.xm.leetcode.everyweek;

import java.util.Arrays;

class Solution3915 {

    /**
     * 解题思路：逆序动态规划 + 最大树状数组（维护区间最大值）
     * 约束：选中的下标间隔 ≥k；数值交替峰谷（递增/递减交替）
     * 时间复杂度：O(n log M) M为数组最大值
     */
    public long maxAlternatingSum(int[] nums, int k) {
        int n = nums.length;
        // 找到数组中的最大值，用于确定树状数组的大小（直接用数值作为下标，无需离散化）
        int max = 0;
        for (int x : nums) max = Math.max(x, max);

        // 树状数组：tree[0]维护递增状态dp最大值，tree[1]维护递减状态dp最大值
        long[][] tree = new long[2][max + 1];
        // dp[0][i]：以i为起点，向后【递增】(nums[i] < 后一个数)的最大交替和
        // dp[1][i]：以i为起点，向后【递减】(nums[i] > 后一个数)的最大交替和
        long[][] dp = new long[2][n];
        // 存储最终答案：全局最大交替和
        long res = 0;

        // 核心：逆序遍历数组（从后往前），天然满足下标间隔 ≥k 的约束
        for (int i = n - 1; i >= 0; i--) {
            // 初始状态：子序列只有nums[i]一个元素，交替和为自身
            dp[0][i] = dp[1][i] = nums[i];

            // 延迟更新：只有 i+k 不越界时，才将 i+k 位置加入树状数组
            // 保证：树状数组中只有 ≥i+k 的元素，满足「选i则下一个必须≥i+k」的约束
            if (i + k < n) {
                // 将 i+k 位置的【递增状态】更新到 tree[0]，下标用 nums[i+k] 本身
                update(nums[i + k], dp[0][i + k], tree[0]);
                // 将 i+k 位置的【递减状态】更新到 tree[1]
                // 技巧：max - nums[i+k] + 1 → 把后缀查询翻转成前缀查询（树状数组只支持前缀）
                update(max - nums[i + k] + 1, dp[1][i + k], tree[1]);

                // 计算 dp[0][i]：以i开头，向后递增 → 后面的数必须 > nums[i]
                // 只能从【递减状态】转移，查询 tree[1] 中数值 > nums[i] 的最大值
                if (nums[i] + 1 <= max) {
                    dp[0][i] += query(max - (nums[i] + 1) + 1, tree[1]);
                }

                // 计算 dp[1][i]：以i开头，向后递减 → 后面的数必须 < nums[i]
                // 只能从【递增状态】转移，查询 tree[0] 中数值 < nums[i] 的最大值
                if (nums[i] - 1 >= 0) {
                    dp[1][i] += query(nums[i] - 1, tree[0]);
                }
            }

            // 更新全局最大值：所有位置的两种状态都要比较
            res = Math.max(res, dp[0][i]);
            res = Math.max(res, dp[1][i]);
        }
        return res;
    }

    /**
     * 最大树状数组 - 更新操作
     * @param j 树状数组下标（数值本身/翻转后的下标）
     * @param x 要更新的值（dp的最大值）
     * @param tree 对应的树状数组
     */
    private void update(int j, long x, long[] tree) {
        while (j < tree.length) {
            // 树状数组存储最大值：保留更大的值
            tree[j] = Math.max(x, tree[j]);
            // 树状数组标准更新步长
            j += j & -j;
        }
    }

    /**
     * 最大树状数组 - 查询操作
     * @param j 查询前缀 [1, j] 的最大值
     * @param tree 对应的树状数组
     * @return 区间最大值
     */
    private long query(int j, long[] tree) {
        long res = 0;
        while (j != 0) {
            // 累加取最大值
            res = Math.max(tree[j], res);
            // 树状数组标准查询步长
            j &= j - 1;
        }
        return res;
    }


    class NumArray {

        private long[] arr;

        public NumArray(int n) {
            arr = new long[n];
        }

        public void update(int index, long val) {
            for (; index < arr.length; index += index & (-index)) {
                arr[index] = Math.max(arr[index], val);
            }
        }

        public long preMax(int index) {
            long res = 0;
            for (; index > 0; index -= index & (-index)) {
                res = Math.max(res, arr[index]);
            }
            return res;
        }

    }

    public long maxAlternatingSum1(int[] nums, int k) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        long[] fInc = new long[n]; // fInc[i] 表示以 nums[i] 结尾且最后两项递增的交替子序列
        long[] fDec = new long[n]; // fDec[i] 表示以 nums[i] 结尾且最后两项递减的交替子序列
        // 值域树状数组
        NumArray inc = new NumArray(n + 1); // 维护 fInc[i] 的最大值
        NumArray dec = new NumArray(n + 1); // 维护 fDec[i] 的最大值

        long res = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            if (i >= k) {
                // 这个时候才把 fInc[i - k] 和 fDec[i - k] 添加到值域树状数组中
                // 保证转移源的下标 <= i - k
                int j = nums[i - k];
                inc.update(n - j, fInc[i - k]);
                dec.update(j + 1, fDec[i - k]);
            }
            int j = Arrays.binarySearch(sorted, x);
            nums[i] = j;
            fInc[i] = dec.preMax(j) + x;
            fDec[i] = inc.preMax(n - j - 1) + x;
            res = Math.max(res, fInc[i]);
            res = Math.max(res, fDec[i]);
        }
        return res;
    }
}
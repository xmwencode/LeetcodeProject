package com.xm.leetcode.everyday;

import java.util.Arrays;

class Solution3464 {
    public int maxDistance(int side, int[][] points, int k) {
        // 核心思路：
        // 1. 正方形边界上两点的曼哈顿距离 = 沿着正方形边的最短路径长度
        // 2. 将二维平面上的点 映射成 0~4*side 的一维环形数组，简化距离计算
        // 3. 二分答案：枚举最小距离，判断能否选出 k 个点满足两两距离 >= 当前值
        long[] nums = new long[points.length];
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            if (x == 0) nums[i] = y;
            else if (y == side) nums[i] = side + x;
            else if (x == side) nums[i] = 3L * side - y;
            else nums[i] = 4L * side - x;
        }
        Arrays.sort(nums);
        // 二分查找
        // 左边界：最小可能距离 0
        // 右边界：理论最大距离（均分周长）+1，保证覆盖所有可能
        int l = 0, r = (int) (side * 4L / k) + 1;

        while (l <= r) {
            // 取中间值作为当前要验证的【最小距离】
            int mid = (l + r) / 2;
            // check：是否能选出 k 个点，满足任意两点之间距离 >= mid
            if (check(nums, side, k, mid)) {
                // 满足条件：说明距离可以更大，尝试更大值
                l = mid + 1;
            } else {
                // 不满足条件：距离太大了，缩小范围
                r = mid - 1;
            }
        }
        return r;
    }

    /**
     * 检查函数：给定最小距离要求 low，能否选出 k 个点
     *
     * @param a    排序后的一维点数组
     * @param side 正方形边长
     * @param k    要选的点数量
     * @param low  要求的最小距离
     * @return true=可以选出，false=无法选出
     */
    private boolean check(long[] a, int side, int k, int low) {
        // 枚举每一个点作为【第一个选中的点】（环形结构必须枚举）
        for (long start : a) {
            // 最后一个点的最大上限：
            // 保证最后一个点 和 起点 的环形距离 >= low
            long end = start + side * 4L - low;
            // 当前选中的最后一个点
            long cur = start;
            // 标记：以当前点为起点，是否能选够 k 个点
            boolean flag = true;

            // 已经选了起点，还需要选 k-1 个点
            for (int i = 0; i < k - 1; i++) {
                // 二分查找：第一个 >= cur + low 的点（保证距离 >= low）
                int j = lowerBound(a, cur + low);
                if (j == a.length || a[j] > end) {
                    flag = false;
                    break;
                }
                // 更新当前最后一个点
                cur = a[j];
            }
            // 如果这个起点能选够 k 个点，直接返回 true
            if (flag) {
                return true;
            }
        }
        return false;
    }

    /**
     * 二分查找：找到第一个 >= target 的元素下标（闭区间写法）
     *
     * @param nums   有序数组
     * @param target 目标值
     * @return 第一个 >= target 的下标，找不到返回数组长度
     */
    private int lowerBound(long[] nums, long target) {
        // 二分查找不小于 target 的最左边元素【闭区间写法】
        int l = 0, r = nums.length - 1;
        int res = nums.length;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                // 找到一个候选值，记录下标，继续向左找更小的下标
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        // 返回第一个 >= target 的下标
        return res;
    }
}
package com.xm.leetcode.everyday;

import java.util.Arrays;

class Solution2126 {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        // 计算最大数的二进制位数
        int mx = 0;
        for (int x : asteroids) {
            mx = Math.max(mx, x);
        }
        // Integer.numberOfLeadingZeros(x) 求 x 的前导 0 个数
        int maxWidth = 32 - Integer.numberOfLeadingZeros(mx);
        // 计算第 i 组中行星质量之和
        long[] sum = new long[maxWidth];
        // 保存第 i 组中最小的行星的质量
        int[] minWeight = new int[maxWidth];
        Arrays.fill(minWeight, Integer.MAX_VALUE);
        // 遍历行星进行分组
        for (int x : asteroids) {
            // 计算当前数的二进制位数 - 1，得到分组下标 i
            int i = 31 - Integer.numberOfLeadingZeros(x);
            sum[i] += x;
            minWeight[i] = Math.min(minWeight[i], x);
        }
        long m = mass;
        // 从低到高模拟摧毁过程
        for (int i = 0; i < maxWidth; i++) {
            // 本组没有小行星，跳过
            if (minWeight[i] == Integer.MAX_VALUE) continue;
            if (m < minWeight[i]) {
                return false;
            }
            m += sum[i];
        }
        return true;
    }
}
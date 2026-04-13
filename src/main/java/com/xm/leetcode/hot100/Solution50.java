package com.xm.leetcode.hot100;

class Solution50 {
    public double myPow(double x, int N) {
        // 核心：将 n 看作二进制数
        long n = N;
        double res = 1;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        while(n > 0) {
            if ((n & 1) == 1) res *= x;
            x *= x;
            n >>= 1;
        }
        return res;
    }
}
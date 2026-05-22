package com.xm.leetcode.everyday;

import java.util.HashMap;
import java.util.Map;

class Solution2657 {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] C = new int[A.length];
        long p = 0, q = 0;
        for (int i = 0; i < A.length; i++) {
            p |= 1L << A[i];
            q |= 1L << B[i];
            C[i] = Long.bitCount(p & q);
        }
        return C;
    }
}
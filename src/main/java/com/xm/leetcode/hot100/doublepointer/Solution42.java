package com.xm.leetcode.hot100.doublepointer;

class Solution42 {
    public int trap(int[] height) {
        int res = 0;
        int lm = 0, rm = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            lm = Math.max(lm, height[i]);
            rm = Math.max(rm, height[j]);
            if (lm <= rm) {
                res += lm - height[i];
                i++;
            } else {
                res += rm - height[i];
                j--;
            }
        }
        return res;
    }

    public int trap2(int[] height) {
        int res = 0;
        int n = height.length;
        int[] l = new int[n];
        int[] r = new int[n];
        l[0] = height[0];
        r[n - 1] = height[n - 1];
        for (int i = 1; i < n; i ++ ) {
            l[i] = Math.max(height[i], l[i - 1]);
        }
        for (int j = n - 2; j >= 0; j -- ) {
            r[j] = Math.max(height[j], r[j + 1]);
        }
        for (int i = 0; i < n; i ++ ) {
            res += Math.min(l[i], r[i]) - height[i];
        }

        return res;
    }

}
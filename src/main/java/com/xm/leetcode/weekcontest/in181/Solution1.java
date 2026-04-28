package com.xm.leetcode.weekcontest.in181;

class Solution1 {
    public boolean validDigit(int n, int x) {
        String s = String.valueOf(n);
        char c = (char) (x + '0');
        if (s.charAt(0) == c) return false;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == c) return true;
        }
        return false;
    }
}
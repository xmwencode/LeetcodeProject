package com.xm.leetcode.everyday;

class Solution2833 {
    public int furthestDistanceFromOrigin(String moves) {
        int left = 0, right = 0, other = 0;
        int n = moves.length();
        for (int i = 0; i < n; i++) {
            char c = moves.charAt(i);
            switch (c) {
                case 'L':
                    left++;
                    break;
                case 'R':
                    right++;
                    break;
                case '_':
                    other++;
                    break;
            }
        }
        return Math.abs(left - right) + other;
    }
}
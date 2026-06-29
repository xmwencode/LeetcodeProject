package com.xm.leetcode.everyday;

class Solution1967 {
    public int numOfStrings(String[] patterns, String word) {
        int cnt = 0;
        for (String p : patterns) {
            if (word.contains(p)) cnt++;
        }
        return cnt;
    }
}
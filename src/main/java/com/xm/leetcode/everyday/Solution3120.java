package com.xm.leetcode.everyday;

class Solution3120 {
    public int numberOfSpecialChars(String word) {
        int[] cnt = new int[52];
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isLowerCase(c)) {
                cnt[c - 'a']++;
            } else {
                cnt[c - 'A' + 26]++;
            }
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i + 26] > 0) {
                count++;
            }
        }
        return count;
    }
}
package com.xm.leetcode.everyday;

class Solution3121 {
    public int numberOfSpecialChars(String word) {
        int[] cnt = new int[52];
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isLowerCase(c)) {
                // 小写字母，前面不能出现大写字母
                int index = c - 'a';
                if (cnt[index] == -1) continue;
                if (cnt[index + 26] > 0) {
                    cnt[index] = -1;
                }
                cnt[index]++;
            } else {
                // 大写字母
                int index = c - 'A';
                cnt[index + 26]++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i + 26] > 0) {
                count++;
            }
        }
        return count;
    }


    public int numberOfSpecialChars1(String word) {
        int lower = 0, upper = 0, invalid = 0;
        for (char c : word.toCharArray()) {
            int bit = 1 << (c & 31);
            if ((c & 32) > 0) { // 小写字母
                lower |= bit;
                if ((upper & bit) > 0) { // c 在大写子母中
                    invalid |= bit;
                }
            } else { // 大写字母
                upper |= bit;
            }
        }
        // 取出 lower 与 upper 交集中不合法的字母 invalid
        return Integer.bitCount(lower & upper & ~invalid);
    }
}
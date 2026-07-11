package com.xm.leetcode.hoot100;

class Solution76 {
    public String minWindow(String s, String t) {
        // 需要的字符种类数
        int need = 0;
        // 统计 t 中每一个字符以及出现的次数
        int[] cnt = new int[128];
        for (char c : t.toCharArray()) {
            if (cnt[c] == 0) need++;
            cnt[c]--;
        }
        // 已经达到需求的字符类型
        int hasSize = 0;
        // 维护左指针，以及当前当前最小覆盖窗口的起始值、窗口大小
        int left = 0;
        int begin = -1;
        int end = s.length();
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            // 右侧字符移入窗口
            cnt[c]++;
            if (cnt[c] == 0) {
                // 达到数量需求
                hasSize++;
            }
            while (need == hasSize) {
                // 寻找最小窗口
                if (right - left < end - begin) {
                    begin = left;
                    end = right;
                }
                // 左端点字符
                char x = s.charAt(left);
                // 判断如果将该字符移出，是否会减少出现的种类数
                if (cnt[x] == 0) {
                    hasSize--;
                }
                // 左端点移出
                cnt[x]--;
                left++;
            }
        }

        return begin == -1 ? "" : s.substring(begin, end + 1);
    }
}
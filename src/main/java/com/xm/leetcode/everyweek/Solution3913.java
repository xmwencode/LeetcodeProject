package com.xm.leetcode.everyweek;

import java.util.*;

class Solution3913 {

    public String sortVowels(String s) {
        Map<Character, Integer> vowels = new LinkedHashMap<>();
        Map<Character, Integer> firstPos = new LinkedHashMap<>();
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            char c = str[i];
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                // 记录元音字母第一次出现的位置
                if (!firstPos.containsKey(c)) firstPos.put(c, i);
                // 出现次数 + 1
                vowels.put(c, vowels.getOrDefault(c, 0) + 1);
            }
        }
        // 按出现频率排序
        List<Map.Entry<Character, Integer>> sortedList = vowels.entrySet().stream().sorted(
                (o1, o2) -> {
                    // 频率相同，按第一次出现的位置排序
                    if (o1 == o2) {
                        return Integer.compare(firstPos.get(o1.getKey()), firstPos.get(o2.getKey()));
                    }
                    // 按频率降序排列
                    return Integer.compare(o2.getValue(), o1.getValue());
                }
        ).toList();
        // 将排序后的字符串展开成队列
        Deque<Character> vowelQueue = new ArrayDeque<>();
        sortedList.forEach(entry -> {
            char c = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                vowelQueue.offer(c);
            }
        });
        // 重构字符串
        StringBuilder sb = new StringBuilder();
        for (char c : str) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                sb.append(vowelQueue.poll());
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
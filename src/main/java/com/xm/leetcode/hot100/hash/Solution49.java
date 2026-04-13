package com.xm.leetcode.hot100.hash;

import java.util.*;
import java.util.stream.Collectors;

class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> {
            // 将其转换成数组，并按规则进行排序
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            return new String(charArray);
        })).values());
    }
}
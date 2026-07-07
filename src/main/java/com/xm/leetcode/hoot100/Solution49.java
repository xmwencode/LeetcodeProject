package com.xm.leetcode.hoot100;

import java.util.*;

class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortStr = String.valueOf(charArray);
            map.computeIfAbsent(sortStr, s -> new ArrayList<>()).add(str);
        }
        return map.values().stream().toList();
    }
}
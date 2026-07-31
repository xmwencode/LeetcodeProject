package leetcode.hot100;

import java.util.*;

class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            if (map.containsKey(String.valueOf(chars))) {
                map.get(String.valueOf(chars)).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(String.valueOf(chars), list);
            }
        }
        return new ArrayList<>(map.values());
    }
}
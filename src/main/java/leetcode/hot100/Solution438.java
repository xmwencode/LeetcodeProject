package leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        // 存储 p 中字串数量
        int[] pCnt = new int[26];
        // 存储 s 中字串数量
        int[] sCnt = new int[26];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            pCnt[p.charAt(i) - 'a']++;
        }
        int n = s.length(), m = p.length();
        for (int right = 0; right < n; right++) {
            sCnt[s.charAt(right) - 'a']++;
            int left = right - m + 1;
            if (left >= 0) {
                if (Arrays.equals(pCnt, sCnt)) {
                    ans.add(left);
                }
                sCnt[s.charAt(left) - 'a']--;
            }
        }
        return ans;
    }
}
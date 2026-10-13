package leetcode.ling.slidingwindow.fixedlength;

import java.util.ArrayList;
import java.util.List;

class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length(), m = p.length();
        int[] cnt = new int[26];
        int need = 0;
        for (int i = 0; i < m; i++) {
            if (cnt[p.charAt(i) - 'a']++ == 0) need++;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // 入端点
            if (--cnt[s.charAt(i) - 'a'] == 0) need--;
            int l = i - m + 1;
            if (l < 0) continue;
            // 计算
            if (need == 0) {
                ans.add(l);
            }
            // 出端点
            if (cnt[s.charAt(l) - 'a']++ == 0) need++;
        }
        return ans;
    }
}
package leetcode.ling.slidingwindow.fixedlength;

import java.util.HashMap;
import java.util.Map;

class Solution1297 {

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        // 记录窗口中字母对应的数量
        int[] cnt = new int[256];
        // 记录子字符串出现的数量
        Map<String, Integer> map = new HashMap<>();
        // 贪心：本质上只需考虑长度恰好等于 minSize 的子串即可
        int ans = 0;
        int m = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            // 入端点
            char in = s.charAt(i);
            if (cnt[in] == 0) m++;
            cnt[in]++;
            int l = i - minSize + 1;
            if (l < 0) continue;
            // 计算
            if (m <= maxLetters) {
                String str = s.substring(l, l + minSize);
                Integer count = map.merge(str, 1, Integer::sum);
                ans = Math.max(ans, count);
            }
            // 出端点
            char out = s.charAt(l);
            cnt[out]--;
            if (cnt[out] == 0) m--;
        }
        return ans;
    }
}
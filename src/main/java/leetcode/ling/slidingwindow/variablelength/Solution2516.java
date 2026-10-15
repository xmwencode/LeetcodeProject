package leetcode.ling.slidingwindow.variablelength;

class Solution2516 {
    public int takeCharacters(String s, int k) {
        // 取走每种字符至少 k 个，只能留下最多 cnt[i] - k 个
        char[] str = s.toCharArray();
        int n = str.length;
        int[] cnt = new int[3];
        int ans = 0;
        int extra = 0;
        for (char c : str) {
            cnt[c - 'a']++;
        }
        if (cnt[0] < k || cnt[1] < k || cnt[2] < k) {
            return -1;
        }
        // 当前窗口中字符的数量
        int[] winCnt = new int[3];
        for (int l = 0, r = 0; r < n; r++) {
            if (winCnt[str[r] - 'a']++ == cnt[str[r] - 'a'] - k) {
                extra++;
            }
            // 左指针压缩
            while (extra > 0) {
                if (--winCnt[str[l] - 'a'] == cnt[str[l] - 'a'] - k) {
                    extra--;
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return n - ans;
    }
}
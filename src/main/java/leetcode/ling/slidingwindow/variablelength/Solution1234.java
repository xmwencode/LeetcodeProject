package leetcode.ling.slidingwindow.variablelength;

class Solution1234 {
    public int balancedString(String s) {
        // 只需要将多出来的字符串替换掉即可
        char[] str = s.toCharArray();
        int n = str.length;
        int m = n / 4;
        int[] cnt = new int[128];
        for (char c : str) {
            cnt[c]++;
        }
        if (cnt['Q'] == m && cnt['W'] == m && cnt['E'] == m && cnt['R'] == m) {
            return 0;
        }
        int ans = n + 1;
        for (int l = 0, r = 0; r < n; r++) {
            cnt[str[r]]--;
            // 窗口内字符数量都小于 m, 说明窗口外有一种字符数量大于 m, 必定不符合最小窗口
            while (cnt['Q'] <= m && cnt['W'] <= m && cnt['E'] <= m && cnt['R'] <= m) {
                cnt[str[l++]]++;
                ans = Math.min(ans, r - l + 1);
            }
        }
        return ans;
    }
}
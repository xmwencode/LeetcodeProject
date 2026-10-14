package leetcode.ling.slidingwindow.variablelength;

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        // 记录窗口中字符数量
        int[] cnt = new int[256];
        int ans = 0;
        // 只滑动右端点
        for (int l = 0, r = 0; r < n; r++) {
            // 入端点
            int curIndex = str[r];
            cnt[curIndex]++;
            // 窗口压缩
            while (cnt[str[r]] > 1) {
                cnt[str[l]]--;
                l++; // 左指针右移
            }
            // 计算
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
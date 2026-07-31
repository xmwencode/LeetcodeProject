package leetcode.hot100;

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        // 记录当前子串的字符数量
        int[] cnt = new int[156];
        int ans = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0, j = 0; i < s.length(); i++) {
            char c = charArray[i];
            cnt[c]++;
            while (cnt[c] > 1) {
                cnt[charArray[j++]]--;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}
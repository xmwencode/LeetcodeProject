package leetcode.ling.slidingwindow.variablelength;

class Solution2730 {
    public int longestSemiRepetitiveSubstring(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        int ans = 0;
        // 相邻字符串的数量
        int count = 0;
        for (int l = 0, r = 0; r < n; r++) {
            if (r > 0 && str[r - 1] == str[r]) {
                count++;
            }
            while (count > 1) {
                if (str[l] == str[l + 1]) {
                    count--;
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
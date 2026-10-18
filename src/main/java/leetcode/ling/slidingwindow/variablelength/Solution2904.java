package leetcode.ling.slidingwindow.variablelength;

class Solution2904 {
    public String shortestBeautifulSubstring(String s, int k) {
        char[] str = s.toCharArray();
        int n = str.length;
        if (s.replace("0", "").length() < k) return "";
        String ans = s;
        int cnt = 0;
        for (int l = 0, r = 0; r < n; r++) {
            cnt += str[r] - '0';
            // 压缩左端点
            while (cnt > k || str[l] == '0') {
                cnt -= str[l++] - '0';
            }
            // 计算，恰好等于 k
            if (cnt == k) {
                String newStr = s.substring(l, r + 1);
                if (newStr.length() < ans.length() ||
                        (newStr.length() == ans.length() && newStr.compareTo(ans) < 0)) {
                    ans = newStr;
                }
            }
        }
        return ans;
    }
}
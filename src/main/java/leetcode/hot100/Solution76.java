package leetcode.hot100;

class Solution76 {
    public String minWindow(String s, String t) {
        int end = s.length(), begin = -1;
        // 记录需要满足的字串的数量与种类
        int[] cnt = new int[156];
        int size = 0;
        for (int i = 0; i < t.length(); i++) {
            if (cnt[t.charAt(i)] == 0) size--;
            cnt[t.charAt(i)]--;
        }
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            cnt[c]++;
            if (cnt[c] == 0) {
                size++;
            }
            while (size == 0) {
                // 左指针压缩
                if (right - left < end - begin) {
                    begin = left;
                    end = right;
                }
                // 当前左端点字符
                char x = s.charAt(left);
                if (cnt[x] == 0) {
                    size--;
                }
                // 左端点移除
                cnt[x]--;
                left++;
            }
        }
        return begin == -1 ? "" : s.substring(begin, end + 1);
    }
}
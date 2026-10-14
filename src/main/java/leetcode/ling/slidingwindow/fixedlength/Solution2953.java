package leetcode.ling.slidingwindow.fixedlength;

import java.util.Arrays;

class Solution2953 {
    public int countCompleteSubstrings(String word, int k) {
        char[] str = word.toCharArray();
        int n = str.length;
        int ans = 0;
        int start = 0;
        for (int i = 1; i <= n; i++) {
            if (n == i || Math.abs(str[i] - str[i - 1]) > 2) {
                // 将原字符串分割为在 i 点进行断开，因为 i-1 和 i 不可能形成合法子串
                ans += complete(str, start, i, k);
                start = i;
            }
        }
        return ans;
    }

    private int complete(char[] str, int l, int r, int k) {
        int len = r - l;
        int res = 0;
        for (int m = 1; m <= 26 && m * k <= len; m++) {
            int winLen = m * k;
            // 多出来的字符种类
            int exact = 0;
            int left = l;
            int[] cnt = new int[26];

            for (int right = l; right < r; right++) {
                int index = str[right] - 'a';
                if (cnt[index] == k) exact--;
                cnt[index]++;
                if (cnt[index] == k) exact++;

                // 左端点压缩
                while (right - left + 1 > winLen) {
                    int leftIndex = str[left] - 'a';
                    if (cnt[leftIndex] == k) exact--;
                    cnt[leftIndex]--;
                    if (cnt[leftIndex] == k) exact++;
                    left++;
                }

                if (right - left + 1 == winLen && exact == m) {
                    res++;
                }
            }
        }
        return res;
    }

    public int countCompleteSubstrings2(String word, int k) {
        char[] str = word.toCharArray();
        int n = str.length;
        int ans = 0;

        // 枚举子串中不同字符的数量 m, 对应的窗口长度为 m * k
        for (int m = 1; m <= 26; m++) {
            // 窗口大小
            int winLen = m * k;
            if (winLen > n) break;

            // 窗口内每个字母创先的次数
            int[] cnt = new int[26];
            // 窗口内恰好出现 k 次的字符数量
            int need = 0;
            // 滑动窗口的左边界
            int l = 0;
            for (int r = 0; r < n; r++) {
                int index = str[r] - 'a';
                // 遇到相邻字符差超过 2 的断点，重置整个窗口
                if (r > 0 && Math.abs(str[r] - str[r - 1]) > 2) {
                    l = r;
                    Arrays.fill(cnt, 0);
                    need = 0;
                }
                cnt[index]++;
                if (cnt[index] == k) {
                    need++;
                } else if (cnt[index] == k + 1) {
                    need--;
                }
                // 窗口长度超出，弹出左边字符
                while (r - l + 1 > winLen) {
                    int leftIndex = str[l] - 'a';
                    if (cnt[leftIndex] == k) {
                        need--;
                    } else if (cnt[leftIndex] == k + 1) {
                        need++;
                    }
                    cnt[leftIndex]--;
                    l++;
                }

                if (r - l + 1 == winLen && need == m) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
package leetcode.ling.slidingwindow.variablelength;

class Solution76 {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if (m == 0 || n == 0) return "";
        int[] cntT = new int[256];
        int[] cntS = new int[256];
        int needT = 0;
        int needS = 0;
        for (int i = 0; i < n; i++) {
            if (cntT[t.charAt(i)]++ == 0) {
                needT++;
            }
        }
        int win = Integer.MAX_VALUE;
        int start = 0;
        for (int l = 0, r = 0; r < m; r++) {
            char c = s.charAt(r);
            if (++cntS[c] == cntT[c]) {
                needS++;
            }
            while (needS == needT) {
                if (win > r - l + 1) {
                    win = r - l + 1;
                    start = l;
                }
                char leftChar = s.charAt(l);
                if (cntS[leftChar]-- == cntT[leftChar]) {
                    needS--;
                }
                l++;
            }
        }
        if (win == Integer.MAX_VALUE) return "";
        return s.substring(start, start + win);
    }
}
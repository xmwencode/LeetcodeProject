package leetcode.ling.slidingwindow.fixedlength;

class Solution567 {

    public boolean checkInclusion(String s1, String s2) {
        // 记录 s1 的对应字符种类以及数量
        int n = s1.length(), m = s2.length();
        int[] cnt = new int[26];
        int need = 0;
        for (int i = 0; i < n; i++) {
            int idx = s1.charAt(i) - 'a';
            if (cnt[idx]++ == 0) need++;
        }
        for (int i = 0; i < m; i++) {
            // 入端点
            int idx = s2.charAt(i) - 'a';
            if (--cnt[idx] == 0) need--;
            int l = i - n + 1;
            if (l < 0) continue;
            // 计算
            if (need == 0) return true;
            // 出端点
            int leftIdx = s2.charAt(l) - 'a';
            // 只有s1需要的字符，从满足变成不足 need++
            if (cnt[leftIdx]++ == 0) need++;
        }
        return false;
    }
}
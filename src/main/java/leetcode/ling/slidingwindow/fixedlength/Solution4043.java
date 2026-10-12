package leetcode.ling.slidingwindow.fixedlength;

class Solution4043 {
    public int countRotations(String s, int k) {
        char[] str = s.toCharArray();
        int n = str.length;
        int same = 0;
        int ans = 0;
        for (int i = 0; i < n * 2 - 2; i++) {
            // 1. 入端点
            if (str[i % n] == str[(i + 1) % n]) {
                same++;
            }
            int l = i - n + 2;
            if (l < 0) continue;
            // 2. 计算
            if (k == same) {
                ans++;
            }
            // 3. 出端点
            if (str[l % n] == str[(l + 1) % n]) {
                same--;
            }
        }
        return ans;
    }
}
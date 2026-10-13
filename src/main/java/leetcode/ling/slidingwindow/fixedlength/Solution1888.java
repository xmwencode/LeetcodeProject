package leetcode.ling.slidingwindow.fixedlength;

class Solution1888 {
    public int minFlips(String s) {
        int n = s.length();
        // 在 s + s 中找到一个长度为 n 的子串
        // t = 1 1 [1 0 0 0 1 1] 1 0 0 => 子串
        // 要想让该字串字符交替 进行 0=>1 或 1=>0
        // A.要么变成奇数位全是 1 => 101010 : t[i] != i % 2
        // B.要么变成偶数位全是 1 => 010101 : t[i] == i % 2
        // 将满足 t[i] == i % 2 的字符视为 . 字符 => X.XX.XX.XX.
        // A. 只需要将窗口中的 . => X
        // B. 只需要将窗口中的 X => .
        // 取最小个数即可
        char[] str = s.toCharArray();
        int ans = n;
        int cnt = 0;
        for (int i = 0; i < 2 * n - 1; i++) {
            // 入端.
            cnt += (str[i % n] ^ i) & 1;
            int l = i - n + 1;
            if (l < 0) continue;
            // 计算
            ans = Math.min(ans, Math.min(cnt, n - cnt));
            // 出端
            cnt -= (str[l] ^ l) & 1;
        }
        return ans;
    }
}
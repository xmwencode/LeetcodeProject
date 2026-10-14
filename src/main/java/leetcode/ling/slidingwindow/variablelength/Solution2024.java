package leetcode.ling.slidingwindow.variablelength;

class Solution2024 {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] str = answerKey.toCharArray();
        int n = str.length;
        int ans = 0;
        // 操作次数
        int[] op = new int[2];
        // 变成连续的 T
        for (int l = 0, r = 0; r < n; r++) {
            op[str[r] >> 1 & 1]++;
            while (Math.min(op[0], op[1]) > k) {
                op[str[l++] >> 1 & 1]--;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    public int maxConsecutiveAnswers2(String answerKey, int k) {
        // 最大连续 T 与最大连续 F 各求一遍即可
        char[] str = answerKey.toCharArray();
        int n = str.length;
        int ans = 0;
        // 操作次数
        int op = 0;
        // 变成连续的 T
        for (int l = 0, r = 0; r < n; r++) {
            if (str[r] != 'T') op++;
            while (op > k) {
                if (str[l++] != 'T') op--;
            }
            ans = Math.max(ans, r - l + 1);
        }
        op = 0;
        // 变成连续的 F
        for (int l = 0, r = 0; r < n; r++) {
            if (str[r] != 'F') op++;
            while (op > k) {
                if (str[l++] != 'F') op--;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
package leetcode.ling.slidingwindow.fixedlength;

class Solution2156 {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        char[] str = s.toCharArray();
        int n = str.length;
        int ansL = 0;
        // 当前窗口的哈希值
        long winHash = 0;
        // 预计算 pow[k - 1]
        long p = qpow(power, k - 1, modulo);
        // 倒序滑动，规避整数除法问题
        for (int i = n - 1; i >= 0; i--) {
            // 入窗口
            long t = str[i] - 'a' + 1;
            winHash = (winHash * power + t) % modulo;
            int r = i + k - 1;
            if (r >= n) continue;
            // 计算
            if (winHash == hashValue) {
                ansL = i;
            }
            // 出窗口
            t = str[r] - 'a' + 1;
            winHash = (winHash - t * p % modulo + modulo) % modulo;
        }
        return s.substring(ansL, ansL + k);
    }

    private long qpow(long x, int n, int mod) {
        long res = 1 % mod;
        for (; n > 0; n /= 2) {
            if (n % 2 > 0) {
                res = res * x % mod;
            }
            x = x * x % mod;
        }
        return res;
    }
}
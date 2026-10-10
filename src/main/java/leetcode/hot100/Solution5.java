package leetcode.hot100;

class Solution5 {

    /**
     * Manacher 算法
     */
    public String longestPalindrome(String s) {
        // 将原字符串每两个字符中间插入新的字符，得到奇数长度的字符串，就不需要考虑奇偶性了
        int n = s.length();
        StringBuilder sb = new StringBuilder("^#");
        for (char c : s.toCharArray()) {
            sb.append(c).append('#');
        }
        sb.append('$');
        String t = sb.toString();
        int m = t.length();

        // p[i] 表示以 t[i] 为中心，向左右能扩展的最大半径（不包含中心本身）
        // 例如 t = #b#a#b#，i 指向中间 a，p [i]=3，代表左右各延伸 3 个字符：#b#a#b#
        int[] p = new int[m];

        // C: 当前已知最右的回文中心点的下标
        int C = 0;
        // R: 该回文的右边界 R = C + p[C]
        int R = 0;

        // 跳过 ^ 和 $
        for (int i = 1; i < m - 1; i++) {
            // 1. i 在 R 内部，取镜像的最小值，p[i] 可直接继承镜像点
            if (i < R) {
                // mirror: i 关于 C 的镜像下标 mirror = 2 * C - i
                int mirror = 2 * C - i;
                p[i] = Math.min(R - i, p[mirror]);
            } else {
                p[i] = 0;
            }
            // 尝试继续向外拓展
            while (t.charAt(i - p[i] - 1) == t.charAt(i + p[i] + 1)) {
                p[i]++;
            }

            // 如果拓展后超过了 R，更新中心点 C 和右边界 R
            if (i + p[i] > R) {
                C = i;
                R = i + p[i];
            }
        }

        // maxP: 当前最大的 P[i] 值
        int maxP = 0;
        // 该 P[i] 所在的中心点下标
        int centerIdx = 0;
        for (int i = 1; i < m - 1; i++) {
            if (p[i] > maxP) {
                centerIdx = i;
                maxP = p[i];
            }
        }
        // 映射为原始字符串
        int start = (centerIdx - maxP) / 2;
        return s.substring(start, start + maxP);
    }

}
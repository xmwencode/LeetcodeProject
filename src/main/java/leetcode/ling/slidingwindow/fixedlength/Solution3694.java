package leetcode.ling.slidingwindow.fixedlength;

import java.util.HashSet;
import java.util.Set;

class Solution3694 {

    public static final int[][] DIRS = new int[128][];

    static {
        DIRS['U'] = new int[]{0, 1};
        DIRS['D'] = new int[]{0, -1};
        DIRS['L'] = new int[]{-1, 0};
        DIRS['R'] = new int[]{1, 0};
    }

    /**
     * 基于第一个窗口进行优化
     */
    public int distinctPoints(String s, int k) {
        int n = s.length();
        Set<Long> set = new HashSet<>();
        char[] str = s.toCharArray();
        set.add((long) n << 20 | n);

        int sx = 0, sy = 0;
        for (int i = k; i < n; i++) {
            sx += DIRS[str[i - k]][0] - DIRS[str[i]][0];
            sy += DIRS[str[i - k]][1] - DIRS[str[i]][1];
            // 计算 将 sx sy 压缩成一个 long 存储 + n 防止负数
            set.add((long) (sx + n) << 20 | (sy + n));
        }
        return set.size();
    }

    public int distinctPoints2(String s, int k) {
        // 只要一个窗口内四种移动最终影响的 +x, +y 不同，就是一种新的方案
        int sx = 0, sy = 0;
        char[] str = s.toCharArray();
        Set<Long> set = new HashSet<>();
        int n = str.length;
        for (int i = 0; i < n; i++) {
            // 入端点
            sx += DIRS[str[i]][0];
            sy += DIRS[str[i]][1];
            int l = i - k + 1;
            if (l < 0) continue;
            // 计算 将 sx sy 压缩成一个 long 存储
            long next = ((long) (sx + n) << 32 | (sy + n));
            set.add(next);
            // 出端点
            sx -= DIRS[str[l]][0];
            sy -= DIRS[str[l]][1];
        }
        return set.size();
    }
}
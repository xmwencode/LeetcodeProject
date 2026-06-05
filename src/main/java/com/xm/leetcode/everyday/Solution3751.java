package com.xm.leetcode.everyday;

class Solution3751 {
    public int totalWaviness(int num1, int num2) {
        char[] lowS = Long.toString(num1).toCharArray();
        char[] highS = Long.toString(num2).toCharArray();
        int n = highS.length;
        // 1.[当前从高位到低位处理到第 i 位]
        // 2.[当前已经累计的"波动值"]
        // 3.[最后两个有效数位的比较结果]
        // 4.[上一个有效数位的数字]
        int[][][][] memo = new int[n][n][3][10];
        return dfs(0, 0, 0, 0, true, true, lowS, highS, memo);
    }

    /**
     * @param i         当前从高到低处理到第 i 位
     * @param waviness  当前累计的波动值
     * @param lastCmp   上一个数字的比较结果 -1: 上一位 < 上上一位  0: 相等或不足两个有效位 1: 上一位 > 上上一位
     * @param lastDigit 上一个数位的数字
     * @param limitLow  当前位是否受 lowS 限制
     * @param limitHigh 当前位是否受 highS 限制
     * @param lowS      上限字符数组
     * @param highS     下限字符数组
     * @param memo      记忆化缓存
     */
    private int dfs(int i, int waviness, int lastCmp, int lastDigit,
                     boolean limitLow, boolean limitHigh,
                     char[] lowS, char[] highS, int[][][][] memo) {
        if (i == highS.length) {
            // 所有数位处理完毕
            return waviness;
        }
        // 记忆化读取
        if (!limitLow && !limitHigh && memo[i][waviness][lastCmp + 1][lastDigit] > 0) {
            return memo[i][waviness][lastCmp + 1][lastDigit] - 1;
        }
        // 计算当前位的取值范围
        int diff = highS.length - lowS.length;
        int lo = limitLow && i >= diff ? lowS[i - diff] - '0' : 0;
        int hi = limitHigh ? highS[i] - '0' : 9;
        // 前导零判断，不会参与峰谷判断
        boolean isNum = !limitLow || i > diff;
        int res = 0;
        for (int j = lo; j <= hi; j++) {
            int cmp = isNum ? Integer.compare(j, lastDigit) : 0;
            // 峰谷判断与波动值更新
            int w = waviness + (cmp * lastCmp < 0 ? 1 : 0);
            res += dfs(i + 1, w, cmp, j,
                    limitLow && j == lo,
                    limitHigh && j == hi,
                    lowS, highS, memo
            );
        }
        return res;
    }
}
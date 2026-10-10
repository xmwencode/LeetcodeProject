package leetcode.ling.slidingwindow.fixedlength;

class Solution2379 {
    public int minimumRecolors(String blocks, int k) {
        char[] str = blocks.toCharArray();
        int n = str.length;
        // 当前窗口中的黑块数量
        int count = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < str.length; i++) {
            // 入端点
            char c = str[i];
            if (c == 'B') {
                count++;
            }
            int l = i - k + 1;
            if (l < 0) continue;
            // 计算
            ans = Math.min(ans, k - count);
            // 出端点
            if (str[l] == 'B') {
                count--;
            }
        }
        return ans;
    }
}
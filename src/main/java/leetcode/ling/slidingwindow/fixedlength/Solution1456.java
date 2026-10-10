package leetcode.ling.slidingwindow.fixedlength;

class Solution1456 {
    public int maxVowels(String s, int k) {
        char[] str = s.toCharArray();
        int count = 0;
        int ans = 0;
        // 当前定长字串中元音的最大数目
        for (int i = 0; i < str.length; i++) {
            // 1. 入端点
            char c = str[i];
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
            // 计算左端点
            int left = i - k + 1;
            // 窗口长度不足 k，暂未形成窗口
            if (left < 0) continue;

            // 2. 更新答案
            ans = Math.max(ans, count);

            // 3. 出端点
            char x = str[left];
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                count--;
            }
        }
        return ans;
    }
}
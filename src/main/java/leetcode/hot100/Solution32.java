package leetcode.hot100;

import java.util.Stack;

class Solution32 {

    /**
     * DP解法
     */
    public int longestValidParentheses(String s) {
        int n = s.length();
        // dp[i]: 以 s[i] 结尾的最长有效括号的数量
        int[] dp = new int[n];
        char[] str = s.toCharArray();
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (str[i] == '(') {
                dp[i] = 0;
            } else if (i > 0 && str[i - 1] == '(') {
                dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
            } else if (i > 0 && str[i - 1] == ')') {
                // 找到与该 ')' 匹配的 '('
                int j = i - dp[i - 1] - 1;
                if (j >= 0 && str[j] == '(') {
                    dp[i] = dp[i - 1] + 2;
                    if (j > 0) {
                        // 加上前面有效的括号数
                        dp[i] += dp[j - 1];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    /**
     * 栈解法
     */
    public int longestValidParentheses2(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        char[] str = s.toCharArray();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (str[i] == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
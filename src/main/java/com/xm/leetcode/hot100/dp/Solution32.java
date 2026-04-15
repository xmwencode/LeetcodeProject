package com.xm.leetcode.hot100.dp;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution32 {


    public int longestValidParentheses(String s) {
        char[] str = s.toCharArray();
        // dp[i] 表示以 s[i] 结尾的最长有效括号长度
        int[] dp = new int[s.length()];
        int res = 0;
        for (int i = 1; i < str.length; i++) {
            // 如果是 '(' 则不可能结尾
            if (str[i] == '(') dp[i] = 0;
            else {
                // 1. 前一个字符是 '(', 凑成一个括号
                if (str[i - 1] == '(') {
                    // 边界处理
                    dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
                } else {
                    // 2. 前一个字符是 ')', 寻找最前面的 '('
                    int last = i - dp[i - 1] - 1;
                    if (last >= 0 && str[last] == '(') {
                        dp[i] = dp[i - 1] + 2 + (last > 0 ? dp[last - 1] : 0);
                    }
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int longestValidParentheses2(String s) {
        int res = 0;
        char[] str = s.toCharArray();
        // 栈中存储的是下标
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(') {
                // 左括号入栈
                stack.push(i);
            } else {
                // 右括号出栈
                stack.pop();
                if (stack.isEmpty()) {
                    // 记录第一个不合法的括号位置
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }
}
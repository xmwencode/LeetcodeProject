package com.xm.leetcode.hot100.stack;

import java.util.Stack;

class Solution20 {

    public boolean isValid(String s) {
        int[] stack = new int[10010];
        int top = -1;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack[++top] = '(';
            } else if (c == '[') {
                stack[++top] = '[';
            } else if (c == '{') {
                stack[++top] = '{';
            } else if (top > 0 && stack[top--] != c) {
                return false;
            }
        }
        return top < 0;
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                char pop = stack.pop();
                switch (c) {
                    case ')':
                        if (pop != '(') return false;
                        break;
                    case ']':
                        if (pop != '[') return false;
                        break;
                    case '}':
                        if (pop != '{') return false;
                        break;
                }
            }
        }
        return stack.isEmpty();
    }
}
package com.xm.leetcode.hot100.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution739 {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        // 单调递减栈，存储对应温度的下标
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            int x = temperatures[i];
            while (!stack.isEmpty() && temperatures[stack.peek()] <= x) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);

        }
        return res;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        // 单调递减栈，存储对应温度的下标
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                int x = temperatures[i];
                while (!stack.isEmpty() && temperatures[stack.peek()] < x) {
                    Integer top = stack.pop();
                    res[top] = i - top;
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            res[stack.pop()] = 0;
        }
        return res;
    }
}
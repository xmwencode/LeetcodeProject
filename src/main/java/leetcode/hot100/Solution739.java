package leetcode.hot100;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        // 从右向左单调递减栈
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res[i] = 0;
            } else {
                res[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return res;
    }
}
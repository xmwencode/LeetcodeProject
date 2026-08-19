package leetcode.hot100;

import java.util.Deque;
import java.util.LinkedList;

class Solution20 {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (top == '(' && c == ')') continue;
                else if (top == '[' && c == ']') continue;
                else if (top == '{' && c == '}') continue;
                else return false;
            }
        }
        return stack.isEmpty();
    }
}
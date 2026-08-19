package leetcode.hot100;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution394 {
    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        Deque<StringBuilder> stack = new ArrayDeque<>();
        Deque<Integer> numStack = new ArrayDeque<>();
        StringBuilder curStr = new StringBuilder();
        int curNum = 0;

        for (char c : chars) {
            if (Character.isDigit(c)) {
                curNum = curNum * 10 + (c - '0');
            } else if (Character.isLetter(c)) {
                curStr.append(c);
            } else if (c == '[') {
                // 保存现场入栈
                stack.push(new StringBuilder(curStr));
                curStr = new StringBuilder();
                numStack.push(curNum);
                curNum = 0;
            } else if (c == ']') {
                // 出栈并拼接
                int k = numStack.pop();
                StringBuilder pre = stack.pop();
                curStr = pre.repeat(curStr, k);
            }
        }
        return curStr.toString();
    }

}
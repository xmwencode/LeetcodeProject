package com.xm.leetcode.hot100.stack;

import java.util.Stack;

class Solution394 {
    public String decodeString(String s) {
        return decode(s.toCharArray());
    }

    private record Pair(int k, String s) {
    }

    private String decode(char[] s) {
        StringBuilder res = new StringBuilder();
        Stack<Pair> stack = new Stack<>();
        int k = 0;
        for (char c : s) {
            if (Character.isLetter(c)) {
                res.append(c);
            } else if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                stack.push(new Pair(k, res.toString()));
                res.setLength(0);
                k = 0;
            } else if (c == ']') {
                Pair p = stack.pop();
                res = new StringBuilder(p.s).repeat(res, p.k);
            }
        }
        return res.toString();
    }


    public static void main(String[] args) {
        String str = "2[abc3[cd]k]ef";
        System.out.println("str = " + str);
        String res = new Solution394().decode(str.toCharArray());
        System.out.println("最终 res = " + res);
    }


}
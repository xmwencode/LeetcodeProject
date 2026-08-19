package leetcode.hot100;

public class Solution155 {

    class MinStack {

        int[] stack;
        int top = -1;
        int[] minStack; // 存 stack 中的下标
        int minTop = -1;

        public MinStack() {
            stack = new int[30010];
            minStack = new int[30010];
        }

        public void push(int value) {
            stack[++top] = value;
            if (minTop < 0 || stack[minStack[minTop]] >= value) {
                minStack[++minTop] = top;
            }
        }

        public void pop() {
            if (minTop >= 0 && minStack[minTop] == top) {
                minTop--;
            }
            top--;
        }

        public int top() {
            return stack[top];
        }

        public int getMin() {
            return stack[minStack[minTop]];
        }
    }

}

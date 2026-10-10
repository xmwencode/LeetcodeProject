package leetcode.hot100;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution84 {
    public int largestRectangleArea(int[] heights) {
        // 前后补 0 作为哨兵
        int n = heights.length;
        int[] arr = new int[n + 2];
        System.arraycopy(heights, 0, arr, 1, n);
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;

        int m = arr.length;
        for (int i = 0; i < m; i++) {
            // 当前元素小于栈顶相对高度，弹出，计算栈顶作为高的矩形面积
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                int curIdx = stack.pop();
                int height = arr[curIdx];
                int left = stack.peek();    // 左边第一个比它小的下标
                int right = i;              // 右边第一个比它小的下标
                int width = right - left - 1;
                ans = Math.max(ans, width * height);
            }
            stack.push(i);
        }
        return ans;
    }
}
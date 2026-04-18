package com.xm.leetcode.hot100.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution84 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        // 对于任意一个高度，只需要找到左边和右边第一个小于或等于它的高度即可
        // 设置一个单调递增栈
        Deque<Integer> stack = new ArrayDeque<>();
        // 存储左边第一个比 i 小的元素下标
        int[] left = new int[n];
        Arrays.fill(left, -1);
        // 存储右边第一个比 i 小的元素下标
        int[] right = new int[n];
        Arrays.fill(right, n);
        for (int i = 0; i < n; i++) {
            int x = heights[i];
            while(!stack.isEmpty() && x < heights[stack.peek()]) {
                Integer pop = stack.pop();
                right[pop] = i;
            }
            if (!stack.isEmpty()) left[i] = stack.peek();
            stack.push(i);
        }
        // 计算最大面积
        int res = 0;
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            int area = width * heights[i];
            res = Math.max(res, area);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,5,6,2,3};
        new Solution84().largestRectangleArea(nums);
    }
}
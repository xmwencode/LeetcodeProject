package com.xm.leetcode.hot100.heap;

import java.util.PriorityQueue;

class MedianFinder {

    // 大顶堆：存左半部分较小的数
    private final PriorityQueue<Integer> leftMaxHeap;
    // 小顶堆：存右半部分较大的数
    private final PriorityQueue<Integer> rightMinHeap;

    public MedianFinder() {
        leftMaxHeap = new PriorityQueue<>((a, b) -> b - a);
        rightMinHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // 1. 先插入对应堆
        if (leftMaxHeap.isEmpty() || num <= leftMaxHeap.peek()) {
            leftMaxHeap.offer(num);
        } else {
            rightMinHeap.offer(num);
        }

        // 2. 维持堆的平衡：左堆大小 只能 = 右堆 或 右堆+1
        if (leftMaxHeap.size() > rightMinHeap.size() + 1) {
            rightMinHeap.offer(leftMaxHeap.poll());
        }
        if (rightMinHeap.size() > leftMaxHeap.size()) {
            leftMaxHeap.offer(rightMinHeap.poll());
        }
    }

    public double findMedian() {
        // 奇数：左堆堆顶
        if (leftMaxHeap.size() > rightMinHeap.size()) {
            return leftMaxHeap.peek();
        }
        // 偶数：两个堆顶平均值
        return (leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
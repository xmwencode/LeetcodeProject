package leetcode.hot100;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution259 {

    class MedianFinder {

        // 左侧大根堆
        PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
        // 右侧小根堆
        PriorityQueue<Integer> right = new PriorityQueue<>();

        public MedianFinder() {

        }

        public void addNum(int num) {
            if (left.isEmpty() || num <= left.peek()) {
                left.offer(num);
            } else {
                right.offer(num);
            }
            if (left.size() - right.size() > 1) {
                right.offer(left.poll());
            }
            if (right.size() - left.size() > 0) {
                left.offer(right.poll());
            }
        }

        public double findMedian() {
            if (left.isEmpty()) return 0;
            if (left.size() == right.size()) {
                return (left.peek() + right.peek()) / 2.0;
            } else {
                return left.peek();
            }
        }
    }

}

package leetcode.hot100;

import java.util.ArrayDeque;

class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int n = nums.length, idx = 0;
        int[] ans = new int[n - k + 1];

        for (int right = 0; right < nums.length; right++) {
            int left = right - k + 1;
            if (right > 0 && queue.getLast() < left) queue.removeLast();
            while (!queue.isEmpty() && nums[queue.getFirst()] <= nums[right]) {
                queue.removeFirst();
            }
            queue.addFirst(right);
            if (left >= 0) ans[idx++] = nums[queue.getLast()];
        }
        return ans;
    }
}
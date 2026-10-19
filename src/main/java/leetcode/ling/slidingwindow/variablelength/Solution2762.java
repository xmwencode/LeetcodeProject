package leetcode.ling.slidingwindow.variablelength;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution2762 {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        long ans = 0;
        // 记录当前子数组的最大值和最小值所在的下标
        Deque<Integer> minQ = new ArrayDeque<>();
        Deque<Integer> maxQ = new ArrayDeque<>();

        for (int l = 0, r = 0; r < n; r++) {
            int x = nums[r];
            while (!minQ.isEmpty() && x <= nums[minQ.peekLast()]) {
                minQ.pollLast();
            }
            minQ.addLast(r);
            while (!maxQ.isEmpty() && x >= nums[maxQ.peekLast()]) {
                maxQ.pollLast();
            }
            maxQ.addLast(r);

            while (nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > 2) {
                l++;
                if (minQ.peekFirst() < l) minQ.pollFirst();
                if (maxQ.peekFirst() < l) maxQ.pollFirst();
            }
            ans += r - l + 1;
        }
        return ans;
    }
}
package com.xm.leetcode.hot100.others;

class Solution287 {
    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);
        int head = 0;
        while (head != slow) {
            head = nums[head];
            slow = nums[slow];
        }
        return slow;
    }
}
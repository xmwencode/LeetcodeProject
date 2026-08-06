package leetcode.hot100;

import leetcode.utils.ListNode;

public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        // 找到在环中的交点
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) {
            return null;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
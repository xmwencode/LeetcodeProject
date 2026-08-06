package leetcode.hot100;

import leetcode.utils.ListNode;

class Solution206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        // 记录前一个节点
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
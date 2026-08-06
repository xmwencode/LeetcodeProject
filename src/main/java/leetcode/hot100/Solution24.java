package leetcode.hot100;

import leetcode.utils.ListNode;

class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = cur;
            prev.next = next;
            prev = cur;
            cur = cur.next;
        }

        return dummyHead.next;
    }
}
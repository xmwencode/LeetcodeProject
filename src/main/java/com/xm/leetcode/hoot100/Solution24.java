package com.xm.leetcode.hoot100;

import com.xm.leetcode.common.ListNode;

class Solution24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        while (cur != null && cur.next != null) {
            ListNode nextNode = cur.next;
            cur.next = nextNode.next;
            nextNode.next = cur;
            pre.next = nextNode;
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}
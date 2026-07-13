package com.xm.leetcode.hoot100;

import com.xm.leetcode.common.ListNode;

class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 哨兵节点
        ListNode sentry = new ListNode();
        sentry.next = head;
        ListNode node = sentry.next;
        for (int i = 0; i < n; i++) {
            node = node.next;
        }
        // 需要删除的目标节点
        ListNode target = sentry.next;
        // 上一个节点
        ListNode pre = sentry;
        while (node != null) {
            pre = target;
            target = target.next;
            node = node.next;
        }
        pre.next = target.next;
        return sentry.next;
    }
}
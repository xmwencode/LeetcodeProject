package com.xm.leetcode.hoot100;

import com.xm.leetcode.common.ListNode;

class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int t = 0; // 保存上一个和的进位
        // 记录当前指针
        ListNode head = new ListNode(0);
        ListNode node = head;
        while (l1 != null && l2 != null) {
            t += l1.val + l2.val;
            node.next = new ListNode(t % 10);
            node = node.next;
            t /= 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            t += l1.val;
            node.next = new ListNode(t % 10);
            node = node.next;
            t /= 10;
            l1 = l1.next;
        }
        while (l2 != null) {
            t += l2.val;
            node.next = new ListNode(t % 10);
            node = node.next;
            t /= 10;
            l2 = l2.next;
        }
        if (t > 0) {
            node.next = new ListNode(t % 10);
            node = node.next;
        }
        return head.next;
    }

}
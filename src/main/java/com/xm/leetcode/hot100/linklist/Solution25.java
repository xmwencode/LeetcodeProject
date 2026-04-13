package com.xm.leetcode.hot100.linklist;

import com.xm.utils.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 统计节点个数
        int n = 0;
        for (ListNode node = head; node != null; node = node.next) {
            n++;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode cur = head;
        ListNode p0 = dummy;
        ListNode pre = null;
        while (n >= k) {
            int count = 0;
            while (count++ < k && cur != null) {
                // 进行翻转
                ListNode nextNode = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nextNode;
            }
            p0.next.next = cur;
            ListNode nextNode = p0.next;
            p0.next = pre;
            p0 = nextNode;
            n -= k;
        }
        return dummy.next;
    }
}